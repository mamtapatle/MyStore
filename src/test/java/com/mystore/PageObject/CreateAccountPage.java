package com.mystore.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage {
	WebDriver driver;// local driver
	// constructor

	public CreateAccountPage(WebDriver driver)// remote driver
	{
		driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "AccountFrm_firstname")
	WebElement firstName;

	@FindBy(name = "lastname")
	WebElement lastName;

	@FindBy(name = "email")
	WebElement emailId;

	@FindBy(id = "AccountFrm_address_1")
	WebElement address;

	@FindBy(name = "city")
	WebElement city;

	@FindBy(name = "zone_id")
	WebElement state;

	@FindBy(name = "postcode")
	WebElement zipCode;

	@FindBy(name = "country_id")
	WebElement country;

	@FindBy(id = "AccountFrm_loginname")
	WebElement loginName;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@name=\"confirm\"]")
	WebElement confirmPass;

	@FindBy(name = "agree")
	WebElement terms;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement conti;

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterlastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enteremail(String email) {
		emailId.sendKeys(email);
	}

	public void enterAddress(String adrs) {
		address.sendKeys(adrs);
	}

	public void enterCityName(String ct) {
		city.sendKeys(ct);
	}
	
	public void enterStateName(String sname)
	{
		
		Select s=new Select(state);
		s.selectByVisibleText(sname);
	}
	public void enterPostCode(String pin) {
		zipCode.sendKeys(pin);
	}
	
	public void enterCountryName(String countryname) {
		Select s=new Select(country);
		s.selectByVisibleText(countryname);
			}
	public void enterLoginName(String lName) {
		loginName.sendKeys(lName);
	}
	
	public void enterPassword(String pword) {
		password.sendKeys(pword);
	}
	public void enterConfirmPassword(String pword) {
		confirmPass.sendKeys(pword);
	}
	
	public void agreeTerms()
	{
		terms.click();
	}
	
	public void clickOnContinue()
	{
		conti.click();
	}

}
