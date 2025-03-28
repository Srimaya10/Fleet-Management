package action;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.browser;
import utility.screenshot;

public class Baseclass extends wrapper {
	
	
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite(alwaysRun = true)
	public void initial() throws IOException
	{

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File("./Reports/Live_SmokeTest_Result " +System.currentTimeMillis()+  ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		logger = report.createTest("Smoke Test");
		
	}
	
	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException
	{
		
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
		String SystemName=InetAddress.getLocalHost().getHostName();
		Systemout("Commusoft Web-Automation Started in :   "+SystemName +""+"Date:"+""+ date );
		driver=browser.startapplication(driver, "chrome","https://app.commusoft.us/"); //US
		//driver=browser.startapplication(driver, "chrome","https://app.commusoft.us/"); //stage2

	}
	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) throws IOException
	{

		if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, "Method Been Executed Sucessfully:-" +result.getName());
			System.out.println( "Method Been Executed Sucessfully:-" +result.getName());
	
			Systemout("Method Been Executed Sucessfully:-" +result.getName());
		}else 
			if(ITestResult.FAILURE==result.getStatus())
			{
				logger.log(Status.FAIL, "Method Been Failed:-" +result.getName());

				String screenshotPath = screenshot.capture(driver, result.getName());
				if (screenshotPath != null) {
					logger.fail("Test Failed: " + result.getName(),
							MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
				} else {
					logger.fail("Test Failed: " + result.getName() + " (Screenshot capture failed).");
				}
				System.out.println( "Method Been Failed:-" +result.getName());
		
				Systemout("Method Been Failed:-" +result.getName());
			}else
			{
				logger.log(Status.SKIP, "Method been Skiped");
				//				logger.skip(result.getThrowable());
			}

	}
	@AfterSuite
	public void tearDown() throws IOException{
		Date today = new Date();
		SimpleDateFormat  DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");
		String date = DATE_FORMAT.format(today);
	
		Systemout("Commusoft Web-Automation Completed in :   "+InetAddress.getLocalHost().getHostName()+""+"Date:"+""+ date);
		

		report.flush();
	}

	

}
