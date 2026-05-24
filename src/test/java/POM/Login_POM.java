package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_POM extends BasePage
{
   public Login_POM(WebDriver driver)
   {
	   super(driver);
   }
   
   
   public boolean LoginP() throws InterruptedException
   {
	   driver.findElement(By.id("edit-name")).sendKeys("sohelpathan5110@gmail.com");
	   driver.findElement(By.id("edit-pass")).sendKeys("sohel@1234");
	   Thread.sleep(1000);
	  String text=driver.findElement(By.xpath("//span[@class='field-prefix']")).getText();
	  System.out.println(text);
	 text=text.replaceAll("=", " ");
	  
	 String []num=text.split("\\+");
	 int num1=Integer.parseInt(num[0].trim());
	 int num2=Integer.parseInt(num[1].trim());
	 
	 int result=num1+num2;
	 
	 System.out.println(result);
	 
	 driver.findElement(By.id("edit-captcha-response")).sendKeys(String.valueOf(result));
	 Thread.sleep(1000);
	 
	 WebElement el=driver.findElement(By.id("edit-submit"));
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(el));
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true)", el);
	    js.executeScript("arguments[0].click()", el);
	    
	    boolean validate=driver.findElement(By.xpath("//div[@class='messages__content']")).isDisplayed();
	    return validate;
	 
	 
	   
   }
}
