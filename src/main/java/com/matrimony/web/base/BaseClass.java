package com.matrimony.web.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.matrimony.web.utilityFunctions.BrowserFactory;
import com.matrimony.web.utilityFunctions.GeneralFunctions;

public class BaseClass {
	
	/*This class has Before Suite, After Suite, Before Class, After Class, 
	 * Before Method , After Method annotaion implementations*/
	
	public WebDriver driver;
	public static ExtentReports extent;
	public ExtentTest test;
	
	
	@BeforeSuite()
	public void setRxtentReport(){
		// specify location of the report
		  
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/TestReport_"+ GeneralFunctions.getCurrentDateTime()+".html");
		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  
		  // Passing General information To Report
		  extent.setSystemInfo("Host Name", "Test");
		  extent.setSystemInfo("Environemnt", "QA");
		  extent.setSystemInfo("User", "Swapnil");
		  
	}
	
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.launchBrowser();
		BrowserFactory.navigateToUrl(driver);
	}
	
	@AfterMethod 
	public void teardownmethod(ITestResult result)
	{	
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				test.fail("Test Failed below is Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(GeneralFunctions.getScreenshot(driver)).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				test.pass("Test Passed below is Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(GeneralFunctions.getScreenshot(driver)).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			try {
				test.skip("Test Skipped", MediaEntityBuilder.createScreenCaptureFromPath(GeneralFunctions.getScreenshot(driver)).build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterSuite
	public void reportTearDown(){
		extent.flush();
	}
	
}
