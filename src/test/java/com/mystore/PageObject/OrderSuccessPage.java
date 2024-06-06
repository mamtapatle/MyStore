package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPage {
	WebDriver driver;		// local driver
	// constructor

	public OrderSuccessPage(WebDriver driver)// remote driver
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='maintext']")
	WebElement message;
	
	public String getMessage()
	{
		return message.getText();
	}

}
