package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JIO_POM extends BasePage
{
    public JIO_POM(WebDriver driver)
    {
    	super(driver);
    }
    
    public void JioPortal() throws InterruptedException
    {
    	WebElement el=driver.findElement(By.xpath("//span[text()='Reliance Jio Infocomm Limited (RJIL)']"));
    	
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	
    	js.executeScript("arguments[0].scrollIntoView(true)", el);
    	js.executeScript("arguments[0].click()", el);
    	Thread.sleep(2000);
    }	
    public void EnterRechrge()
    {
    	WebElement el2=driver.findElement(By.cssSelector("a[aria-label='Recharge']"));
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement el3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label='Recharge']")));
           
    	el3.click();
    }
    	
   
    public void EnterMobile() throws InterruptedException
    {
    	driver.findElement(By.id("submitNumber")).sendKeys("7620233092");
    	WebElement el=driver.findElement(By.xpath("//button[@class='searchIconBtn j-button j-button-size__xl tertiary icon-primary icon-only']"));
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(el)).click();
    	Thread.sleep(2000);
    	
    	
    	
    }
}
