package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPOM2 extends BasePage
{
    public RegisterPOM2(WebDriver driver)
    {
    	super(driver);
    }
    By User=By.id("edit-mail");
    By Name=By.id("edit-name");
    By FN=By.id("edit-field-full-name-0-value");
    By Mo=By.id("edit-field-mobile-0-mobile");
    By Pr=By.id("edit-field-profession-0-value");
    By po=By.id("edit-field-position-0-value");
    By or=By.id("edit-field-organization-0-value");
    By Se=By.id("edit-field-category");
    By Sub=By.id("edit-submit");
    By valid=By.xpath("//em[@class='placeholder']");
    
    public boolean RegistrationP()
    {
    	driver.findElement(User).sendKeys("sohelpathan5110@gmail.com");
    	driver.findElement(Name).sendKeys("sohelpathan12345");
    	driver.findElement(FN).sendKeys("Sohel Pathan");
    	driver.findElement(Mo).sendKeys("7620233092");
    	driver.findElement(Pr).sendKeys("Student");
    	driver.findElement(po).sendKeys("NA");
    	driver.findElement(or).sendKeys("NA");
    	
    	Select sc=new Select(driver.findElement(Se));
    	sc.selectByIndex(2);
    	
    	WebElement el=driver.findElement(Sub);
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Sub))).click();
    
    boolean status=driver.findElement(valid).isDisplayed();
    return status;
    }
}
