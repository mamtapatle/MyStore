package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.PageObject.ConfirmPage;
import com.mystore.PageObject.LoginPage;
import com.mystore.PageObject.MyAccountPage;
import com.mystore.PageObject.OrderSuccessPage;
import com.mystore.PageObject.SearchResultsPage;
import com.mystore.PageObject.cartPage;
import com.mystore.PageObject.signInPage;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass{
	@Test
	public void verifyOrderPlaced() throws IOException, InterruptedException {
		String product = "Lipstick";

		signInPage pg = new signInPage(driver);
		pg.clickOnRegister();
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginName("kamal");
		lp.enterPassword("kamal123");
		lp.clickOnLogin();

		MyAccountPage mp = new MyAccountPage(driver);
		mp.SearchProduct(product);
		mp.clickOnSearchButton();

		SearchResultsPage sr=new SearchResultsPage(driver);
		String productText=sr.getProductText();
		// Assert.assertTrue(text.contains("Mamta"));
		if (productText.contains("lip")) {

			Assert.assertTrue(true);
			System.out.println("the product is matching");
		} else {
			//getScreenShot(driver, "verifyOrderPlaced");
			Assert.assertTrue(false);
		}
		
		sr.hoverToAccount();
		//Thread.sleep(5000);
		sr.clickOnLogout();
		

	}
	
	
	@Test
	public void FinalOrder() throws IOException, InterruptedException {
		String msg= " YOUR ORDER HAS BEEN PROCESSED!";
		String product = "Lipstick";

		signInPage pg = new signInPage(driver);
		pg.clickOnRegister();
		LoginPage lp = new LoginPage(driver);
		lp.enterLoginName("kamal");
		lp.enterPassword("kamal123");
		lp.clickOnLogin();

		MyAccountPage mp = new MyAccountPage(driver);
		mp.SearchProduct(product);
		mp.clickOnSearchButton();
		
		SearchResultsPage sr=new SearchResultsPage(driver);
		sr.setQuantity("3");
		sr.clickOnAddToCart();
		
		cartPage cartpage=new cartPage(driver);
		cartpage.clickOnCheckOutBtn();
		
		ConfirmPage confirmpage=new ConfirmPage(driver);
		confirmpage.clickOnConfirmBtn();
		
		OrderSuccessPage ordersuccessoage=new OrderSuccessPage(driver);
		String ConfirmMsg=ordersuccessoage.getMessage();
		
		if (ConfirmMsg.equals(msg)) {

			Assert.assertTrue(true);
			System.out.println("The order is placed successfully");
		} else {
			//getScreenShot(driver, "FinalOrder");
			
			Assert.assertTrue(false);
		}

		
	}
		


}
