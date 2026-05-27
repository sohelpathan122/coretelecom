package POM;

import java.io.IOException;
import java.net.HttpURLConnection;  //Used to connect with URL and get response code like 200, 404.
import java.net.MalformedURLException;
import java.net.URL;  // * Used to handle website URLs.
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenLink_POM extends BasePage
{
     public BrokenLink_POM(WebDriver driver)
     {
    	 super(driver);          //* 200 → Valid ,* 404 → Not Found , * 500 → Server Error
		 
		
     }
     
     public void CheckBrokenLinks() throws MalformedURLException, IOException
     {
    	 List<WebElement> link=driver.findElements(By.tagName("a"));  // * Finds all links (`a` tag) from webpage.
    	 for(WebElement l:link)
    	 {
    		 String url=l.getAttribute("href");
    		 
    		 if(url!=null)
    		 {
    			 HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();  // Creates connection with URL.
    			 con.connect();   //* Sends request to server.
    			 if(con.getResponseCode()>=400)  // * Checks response code. * `400+` means broken link.  Examples:
    			 {
    				 System.out.println("get Broken Links " +url);
    			 }
    			 else
    			 {
    				 System.out.println("get valid links " +url);
    			 }
    		 }
    		 
    	 }
    	 
    	


    			


    		
    			
    			

    			

    			

    			


    			

    		

    			

    	 
    	 
     }
}

