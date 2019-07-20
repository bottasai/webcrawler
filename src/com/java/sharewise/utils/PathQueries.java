package com.java.sharewise.utils;

import java.util.*;  
import java.io.*;  
public class PathQueries {  
	Properties prop;
	public PathQueries(String filename)
	{
	      
	    try {
			FileReader reader=new FileReader(filename);  
		    this.prop=new Properties();  
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public String getPath(String property)
	{
		return this.prop.getProperty(property);
	}
public static void main(String[] args)throws Exception{  
   PathQueries pathQ= new PathQueries("crawlpaths.properties");
   
    System.out.println(pathQ.getPath("debt2equity"));   
}  
}  