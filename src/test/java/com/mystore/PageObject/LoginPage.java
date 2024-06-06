package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//create webdriver
	WebDriver driver;//local driver
	//constructor
	public LoginPage(WebDriver driver)//remote driver
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@title='Continue']")
	WebElement continueButton;
	
	
	public void clickOnCont()
	{
		continueButton.click();
	}
	
	
	@FindBy(id="loginFrm_loginname")
	WebElement loginName;
	
	@FindBy(id="loginFrm_password")
	WebElement password;
	
	@FindBy(xpath="//button[@title='Login']")
	WebElement loginBtn;
	
	public void enterLoginName(String name)
	{
		loginName.sendKeys(name);
	}
	public void enterPassword(String pawd)
	{
		password.sendKeys(pawd);
	}
	public void clickOnLogin()
	{
		loginBtn.click();
	}
	
	
}
