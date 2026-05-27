package ExtentUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;

public class Utility  implements ITestListener
{
	public ExtentSparkReporter sr;
	public ExtentReports r;
	public ExtentTest t;
	public String date;
	public String path;
        public void onStart(ITestContext context)
        {
        	String date=new SimpleDateFormat("YYYY.MM.DD.HH.mm.SS").format(new Date());
        	path="./Reports//testreport"+date+".html";
        	sr=new ExtentSparkReporter(path);
        	
        	sr.config().setReportName("Automation Test Cases");
        	sr.config().setDocumentTitle("Telecom Domain Test case");
        	sr.config().setTheme(Theme.DARK);
        	
        	r=new ExtentReports();
        	r.attachReporter(sr);
        	r.setSystemInfo("Tester Name", "Pathan Sohel");
        	r.setSystemInfo("Dev", "Shubham Bhise");
        	r.setSystemInfo("Env", "QA");
        	r.setSystemInfo("TestingType", "Automation");
        	r.setSystemInfo("Browser", "Chrome");
        	
        }
        public void onTestSuccess(ITestResult result)
        {
        	t=r.createTest(result.getTestClass().getName());
        	t.log(Status.PASS, "Test case passed"+result.getName() );
        	try
        	{
        		String base=new BaseClass().Screensot(result.getName());
        		t.addScreenCaptureFromPath(base);
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        	
        }
        public void onTestFailure(ITestResult result)
        {
        	t=r.createTest(result.getTestClass().getName());
        	t.log(Status.FAIL, "Test case Failed"+result.getName());
        	
        	try
        	{
        		String base=new BaseClass().Screensot(result.getName());
        		t.addScreenCaptureFromPath(base);
        	}
        	catch(Exception e)
        	{
        		e.printStackTrace();
        	}
        }
        public void onFinish(ITestContext context)
        {
        	r.flush();
        }
        
}
