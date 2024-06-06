package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	

	
		
		WebDriver driver;		// local driver
		// constructor

		public cartPage(WebDriver driver)// remote driver
		{
//			driver = driver;
//			PageFactory.initElements(driver, this);
//			
		//super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="cart_checkout2")
		WebElement checkoutBtn;
		
		public void clickOnCheckOutBtn()
		{
			checkoutBtn.click();
		}

}
