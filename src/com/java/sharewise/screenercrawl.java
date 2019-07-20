package com.java.sharewise;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.java.sharewise.utils.PathQueries;
 
/**
* Java Program to parse/read HTML documents from File using Jsoup library.
* Jsoup is an open source library which allows Java developer to parse HTML
* files and extract elements, manipulate data, change style using DOM, CSS and
* JQuery like method.
*
* @author Javin Paul
*/
public class screenercrawl{
 
    public static void main(String args[]) {
 
    	Document document = null;
    	Connection.Response postLogin = null;
    	 HashMap<String, String> cookies = new HashMap<String, String>();
    	
    	final String USER_AGENT = "\"Mozilla/5.0 (Windows NT\" +\n" +  
    	         "          \" 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2\"";  
    	 String loginFormUrl = "https://www.screener.in/login/";  
    	 String loginActionUrl = "https://www.screener.in/login/";  
    	 String username = "botta.saisrinivasa@gmail.com";  
    	 String password = "Prince@123";  
    	 
    	// <input type="hidden" name="csrfmiddlewaretoken" value="bkNH3viu1OkyKznFTk9D2DgZgExk8UGDsZn7Qsk6YtNVMxukalxY1obPL857dHiU">
    	
    	
    	try {
    	Connection.Response loginForm = Jsoup.connect("https://www.screener.in/login/")
                 .method(Connection.Method.GET)
                 .execute();
    	 Document loginDoc = loginForm.parse(); // this is the document that contains response html
    	 cookies.putAll(loginForm.cookies());
    	 
    	 String authToken = loginDoc.select("#main-area > form > input[type=hidden]:nth-child(2)")  
    		      .first()  
    		      .attr("value");  
   
    	Map<String, String> mapParams = new HashMap<String, String>();
        mapParams.put("upgrade-insecure-requests", "1");
        mapParams.put("username", username);
        mapParams.put("password", password);
        mapParams.put("csrfmiddlewaretoken",authToken);
        mapParams.put("next","");

        
        System.out.println(authToken);

    	
       postLogin = Jsoup.connect("https://www.screener.in/login")
    		   .referrer("https://www.screener.in/login/")
    		    .cookies(loginForm.cookies())
                .data(mapParams)
		        .method(Connection.Method.POST)
		        .userAgent(USER_AGENT)
                .execute();
       
       System.out.println(postLogin.parse());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
 
        // JSoup Example 2 - Reading HTML page from URL
        Document doc;
        try {
        	PathQueries pathQ= new PathQueries("crawlpaths.properties");
            doc = Jsoup.connect("https://www.screener.in/company/JUSTDIAL/")
            		.cookies(postLogin.cookies())
            		.get();          
            //Elements ele = doc.select(pathQ.getPath("pe"));
            Elements ele = doc.select("div#quick-ratios-placeholder li:nth-child(1) > b");
            System.out.println("Object is :"+ele);
            System.out.println("Value is :"+ele.first().text());
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        


        
//        String cssClass = doc.select("[data-reactid=.0.1.0.4.3.1.1.1.3.0]"); // getting class form HTML element 
 
   
    }
 
}

