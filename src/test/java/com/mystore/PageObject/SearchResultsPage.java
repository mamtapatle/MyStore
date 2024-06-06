package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;		// local driver
	// constructor

	public SearchResultsPage(WebDriver driver)// remote driver
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='bgnone']")
	WebElement textgenerated;
	
	@FindBy(xpath="//span[text()='Account']")
	WebElement account;
	
	@FindBy(xpath="//a[@class='sub menu_logout']")
	WebElement logout;
	
	@FindBy(id="product_quantity")
	WebElement quantity;
	
	@FindBy(xpath  = "//a[@class='cart']")
	WebElement addCart;
	
	public String getProductText()
	{
		String pname = textgenerated.getText();
		return pname;
					
	}
	
	public void hoverToAccount()
	{
		Actions a=new Actions(driver);
		a.moveToElement(account).build().perform();
	}
	
	public void clickOnLogout() {
		logout.click();
		
	}
	
	public void setQuantity(String number) {
		quantity.clear();
		quantity.sendKeys(number);
		
	}
	public void clickOnAddToCart() {
		addCart.click();
		
	}


}
