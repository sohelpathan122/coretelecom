package TestCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
   
	public WebDriver driver;
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
	@AfterClass
	public void TearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	
}
