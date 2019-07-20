package com.java.sharewise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.java.sharewise.utils.PathQueries;
 
public class crawl {
 
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",
                "/usr/bin/chromedriver"); 
        String baseUrl = "https://www.screener.in/login/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
    	PathQueries pathQ= new PathQueries("crawlpaths.properties");

        // launch Chrome and login with creds
        driver.get(baseUrl);
        driver.findElement(By.name("username")).sendKeys("botta.saisrinivasa@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Prince@123");
        driver.findElement(By.className("button-primary")).click();
        
       // driver.findElement(By.xpath("//*[@id=\"top-nav-search\"]/div/input")).sendKeys("TCS");
       // driver.findElement(By.className("addon icon-search")).click();
        driver.get("https://www.screener.in/company/TCS/");

        // get the actual value of the title
        actualTitle = driver.findElement(By.cssSelector(pathQ.getPath("pe"))).getText();
        System.out.println(actualTitle);

       
        //close Firefox
        driver.close();
        
        // exit the program explicitly
        System.exit(0);
    }
 
}
