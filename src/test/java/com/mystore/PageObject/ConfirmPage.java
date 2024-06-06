package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
	

	
		
		WebDriver driver;		// local driver
		// constructor

		public ConfirmPage(WebDriver driver)// remote driver
		{
			driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="checkout_btn")
		WebElement confirmBtn;
		
		public void clickOnConfirmBtn()
		{
			confirmBtn.click();
		}
		
		//YOUR ORDER HAS BEEN PROCESSED!

}
