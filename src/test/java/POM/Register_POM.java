package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register_POM extends BasePage
{
    public Register_POM(WebDriver driver)
    {
    	super(driver);
    }
    
    By reB=By.xpath("//a[@href='/user/register']");
    By title=By.xpath("//h1[@class='title page-title']");
    
    public boolean RegistrionP()
    {  WebElement el=driver.findElement(reB);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(reB)));
    
    JavascriptExecutor js=(JavascriptExecutor)driver;
          
       js.executeScript("arguments[0].scrollIntoView(true)", el);
       js.executeScript("arguments[0].click();",el);
      return driver.findElement(title).isDisplayed();
    
    }
}
