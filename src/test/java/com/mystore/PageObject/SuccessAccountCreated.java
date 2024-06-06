package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessAccountCreated {
	WebDriver driver;// local driver
	// constructor

	public SuccessAccountCreated(WebDriver driver)// remote driver
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@id='customer_menu_top']")
	WebElement customerName;

	public String getUserName() {
		String name = customerName.getText();
		return name;
	}
}
