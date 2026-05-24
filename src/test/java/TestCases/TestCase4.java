package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.MobileAPP_POM;

public class TestCase4 extends BaseClass
{
        @Test
        public void MobileMapTestCase1() throws InterruptedException
        {
        	MobileAPP_POM mp=new MobileAPP_POM(driver);
        	boolean status=mp.MobileappP();
        	Assert.assertTrue(status);
        }
}
