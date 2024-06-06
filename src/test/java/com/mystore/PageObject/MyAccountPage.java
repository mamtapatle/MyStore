package com.mystore.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
	
		WebDriver driver;		// local driver
		// constructor

		public MyAccountPage(WebDriver driver)// remote driver
		{
			driver = driver;
			PageFactory.initElements(driver, this);
		}

//		@FindBy(id = "customer_menu_top")
//		WebElement customerName;
		
		@FindBy(className = "subtext" )
		WebElement customerName;
		
		@FindBy(xpath = "//a[@data-original-title='Logoff']")
		WebElement logout;
		
		@FindBy(id="filter_keyword")
		WebElement search;
		
		@FindBy(xpath="//div[@title=\"Go\"]")
		WebElement searchButton;
		
		
		
		public String getUserName() {
			String name = customerName.getText();
			return name;
		}
		
		public void ClickOnlogoff()
		{
			logout.click();
		}
		
		public String SearchProduct(String product)
		{
			search.sendKeys(product);
			return product;
			
		}
		
		public void clickOnSearchButton()
		{
			searchButton.click();
		}
		
		public void inputProductAndClick(String product)
		{
			//searchButton.click();
			
			
			Actions a=new Actions(driver);
			a.sendKeys(product).click().build().perform();
		}
		
		
		
		

}
