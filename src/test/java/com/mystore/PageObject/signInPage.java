package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signInPage {
//create object of webdriver
	WebDriver driver;//local driver
	public signInPage(WebDriver driver)//remote driver
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//identify webelements
	@FindBy(xpath = "//a[text()='Login or register']")
	WebElement register;
	
	//identify action
	public void clickOnRegister()
		{
		register.click();
		
	}
	
}
