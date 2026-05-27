package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.Test;

import POM.BrokenLink_POM;

public class TestCase6 extends BaseClass
{
     @Test
     public void VerifbrokenLink() throws MalformedURLException, IOException
     {
    	BrokenLink_POM bp=new BrokenLink_POM(driver)	;
    	bp.CheckBrokenLinks();
     }
}
