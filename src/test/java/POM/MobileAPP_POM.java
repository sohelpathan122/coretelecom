package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileAPP_POM extends BasePage
	{
	    public MobileAPP_POM(WebDriver driver)
	    {
	    	super(driver);
	    }
	    
	    public boolean MobileappP() throws InterruptedException
	    {
	    	
	    	WebElement el=driver.findElement(By.xpath("//span[text()='Consumer Info']"));
	    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.elementToBeClickable(el)).click();
	    	
	    	
	    	WebElement el2=driver.findElement(By.xpath("//span[text()='Mobile Coverage Map']"));
	    	wait.until(ExpectedConditions.elementToBeClickable(el2)).click();
	    	boolean valid=driver.findElement(By.id("block-trai-pagetitle-2")).isDisplayed();
	    	return valid;
	    	
	    }
	    
}
