package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Register_POM;

public class RegisterTestCase1 extends BaseClass
{
     @Test
     public void Registration1()
     {
    	Register_POM rp=new Register_POM(driver);
    	boolean status=rp.RegistrionP();
    	Assert.assertTrue(status);
    	
     }
     
}
