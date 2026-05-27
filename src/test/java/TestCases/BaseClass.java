package TestCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
   
	public static WebDriver driver;
	public Properties p;
	@BeforeClass
	public void Setup() throws IOException
	{
		p=new Properties();
		FileReader fr=new FileReader("./src//test//resources//config.properties");
		p.load(fr);
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
	}
	public String Screensot(String sc) throws IOException
	{
		if(driver==null)
		{
			System.out.println("Skipped bz driver is null");
			return null;
		}
		
		String date=new SimpleDateFormat("YYYY.MM.DD.HH.mm.SS").format(new Date());
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
	    String path="./Screenshots//FailedTest"+date+".jpeg";
	    File f2=new File(path);
	   org.openqa.selenium.io.FileHandler.copy(f, f2);
	   return path;
		
	}
	@AfterClass
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
}
