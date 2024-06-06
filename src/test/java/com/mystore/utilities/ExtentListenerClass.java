package com.mystore.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mystore.testcases.BaseClass;

public class ExtentListenerClass extends BaseClass  implements ITestListener  {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	
//	WebDriver driver;
	
	public void configureReport()
	{
		ReadConfig config=new ReadConfig();
		String timestamp=new SimpleDateFormat("yyyy.mm.dd hh.mm.ss").format(new Date());
		String reportName="MyStoreTestReport-"+timestamp+".html";
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+ reportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("os", "win7");
		reports.setSystemInfo("browser", config.getBrowser());
		reports.setSystemInfo("username", "mamta");
		
		
		//configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Listener report" );
		htmlReporter.config().setReportName("This is the report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		configureReport();
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of the passed test: "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed testcase is: "+result.getName(),ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		test=reports.createTest(result.getName());
		String dateName = new SimpleDateFormat("yyyy.MM.dd hh.mm.ss").format(new Date());
		System.out.println("Name of the failed test: "+result.getName());
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed testcase is: "+result.getName(),ExtentColor.RED));
		
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String testCaseName = result.getMethod().getMethodName();
		String filePath=null;
		try {
			filePath = getScreenShot(driver, testCaseName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
//		String testCaseName = result.getMethod().getMethodName();
//		String filePath=null;
//		
//		String screenShotPath=System.getProperty("user.dir")+"\\screenshots\\"+result.getName()+dateName+".png";
//		File screenShotFile=new File(screenShotPath);
//		if(screenShotFile.exists())
//		{
//			test.fail("Captured image is below "+test.addScreenCaptureFromPath(screenShotPath));
//		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Name of the skipped test"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped testcase is: "+result.getName(),ExtentColor.BLUE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	reports.flush();
	}

	
	
	/* String testName = result.getMethod().getMethodName();
    Object currentClass = result.getInstance();
    WebDriver driver = ((TestBase) currentClass).driver;  // Access the driver from the current test class

    String screenshotPath = getScreenshot(testName, driver);

    extentTest.addScreenCaptureFromPath(screenshotPath); */

}
