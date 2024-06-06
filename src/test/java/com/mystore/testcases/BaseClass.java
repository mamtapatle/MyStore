package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig read=new ReadConfig();
	String url=read.getBaseUrl();
	//String browser=read.getBrowser();
	 public WebDriver driver;
	public static  Logger log;
	String browser=System.getProperty("browser")!=null?System.getProperty("browser"):read.getBrowser();
	
	@BeforeMethod
	public void setup()
	{
				
		
		if(browser.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			
			if(browser.contains("headless"))
			{
				options.addArguments("headless");
			
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}else if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
		}

		else
			driver=null;
			
		
		
		//implicit wait for all webelemets
		driver.manage().timeouts().implicitlyWait(Duration
				.ofSeconds(10));
		
		driver.manage().window().maximize();
		//for logging
		log=LogManager.getLogger(BaseClass.class);
		log.info("this is just a trail");
		driver.get(url);
	
}
	@AfterMethod
	public void tearDown()
	{
	//	driver.close();
		driver.quit();
	}
	
	//screenshot
	
	public String  getScreenShot(WebDriver driver,String testName) throws IOException
	{
		String dateName = new SimpleDateFormat("yyyy.MM.dd hh.mm.ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"//screenshots//"+testName+dateName+".png";
		
		FileUtils.copyFile(src, new File(screenshotPath));
	return screenshotPath;
		
		
	}
	

}
