package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.RegisterPOM2;

public class TestCase2 extends RegisterTestCase1
{
    @Test
    public void RegiCredintial()
    {
    	RegisterPOM2 rg=new RegisterPOM2(driver);
    	boolean status=rg.RegistrationP();
    	Assert.assertTrue(status);
    }
}
