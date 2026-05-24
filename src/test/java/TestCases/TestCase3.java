package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.Login_POM;

public class TestCase3 extends BaseClass
{
  @Test
  public void LoginProcess() throws InterruptedException
  {
	  Login_POM lp=new Login_POM(driver);
	  boolean status=lp.LoginP();
	  Assert.assertTrue(status);
  }
}
