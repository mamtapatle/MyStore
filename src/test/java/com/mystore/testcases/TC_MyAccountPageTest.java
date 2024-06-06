package com.mystore.testcases;

import java.io.IOException;

import javax.naming.directory.SearchResult;

import org.testng.annotations.*;

import com.mystore.PageObject.CreateAccountPage;
import com.mystore.PageObject.LoginPage;
import com.mystore.PageObject.MyAccountPage;
import com.mystore.PageObject.SearchResultsPage;
import com.mystore.PageObject.SuccessAccountCreated;
import com.mystore.PageObject.signInPage;

import junit.framework.Assert;

public class TC_MyAccountPageTest extends BaseClass {

	@Test
	public void verifyRegistartionAndLogin() throws IOException {

		signInPage pg = new signInPage(driver);
		pg.clickOnRegister();
		LoginPage lp = new LoginPage(driver);
		lp.clickOnCont();

		CreateAccountPage createAcc = new CreateAccountPage(driver);
		createAcc.enterFirstName("Mamta");
		createAcc.enterlastName("Patle");
		createAcc.enteremail("mammu1@gmail.com");
		createAcc.enterAddress("Aundh");
		createAcc.enterCityName("Pune");
		createAcc.enterCountryName("India");
		createAcc.enterPostCode("411007");

		createAcc.enterStateName("Maharashtra");
		createAcc.enterLoginName("mammu2");
		createAcc.enterPassword("mamta1234");
		createAcc.enterConfirmPassword("mamta1234");
		createAcc.agreeTerms();
		createAcc.clickOnContinue();

		SuccessAccountCreated accountObj = new SuccessAccountCreated(driver);

		String text = accountObj.getUserName();

		if (text.equalsIgnoreCase("Mamta")) {

			Assert.assertTrue(true);
		} else {
		//	getScreenShot(driver, "verifyRegistartionAndLogin");
			Assert.assertTrue(false);
		}
		// Assert.assertTrue(text.contains("Mamta"));

	}

	@Test
	public void verifyAccount() throws IOException {

		signInPage pg = new signInPage(driver);
		pg.clickOnRegister();
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginName("mammu1");
		lp.enterPassword("mamta123");
		lp.clickOnLogin();

		MyAccountPage mp = new MyAccountPage(driver);
		String text = mp.getUserName();
		// Assert.assertTrue(text.contains("Mamta"));
		if (text.equalsIgnoreCase("Mamta")) {

			Assert.assertTrue(true);
		} else {
			//getScreenShot(driver, "verifyAccount");
			Assert.assertTrue(false);
		}

	}

	}
