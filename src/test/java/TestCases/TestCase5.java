package TestCases;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.JIO_POM;

public class TestCase5 extends TestCase4
{
	public JIO_POM jp=new JIO_POM(driver);
    @Test
    public void JioPortal() throws InterruptedException
    {
    	jp=new JIO_POM(driver);
    	jp.JioPortal();
    	Set<String> ids=driver.getWindowHandles();
    	for(String win:ids)
    	{
    		driver.switchTo().window(win);
    	}
    	Thread.sleep(3000);
    	jp.EnterRechrge();
    	jp.EnterMobile();
    	
    }
   
}
