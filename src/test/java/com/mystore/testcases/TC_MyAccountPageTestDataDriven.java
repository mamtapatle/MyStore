package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.*;

import com.mystore.PageObject.CreateAccountPage;
import com.mystore.PageObject.LoginPage;
import com.mystore.PageObject.MyAccountPage;
import com.mystore.PageObject.SuccessAccountCreated;
import com.mystore.PageObject.signInPage;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTestDataDriven extends BaseClass {

//	@Test
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

		if(text.equalsIgnoreCase("Mamta"))
		{
			
			Assert.assertTrue(true);
		}
		else {
			//getScreenShot(driver, "verifyRegistartionAndLogin");
			Assert.assertTrue(false);
		}
	//	Assert.assertTrue(text.contains("Mamta"));

	}
	
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifyAccount(String loginName,String password,String cnftext) throws IOException {
	
		
	signInPage pg = new signInPage(driver);
	pg.clickOnRegister();
	LoginPage lp = new LoginPage(driver);
	lp.enterLoginName(loginName);
	lp.enterPassword(password);
	lp.clickOnLogin();
	
	MyAccountPage mp=new MyAccountPage(driver);
	String text=mp.getUserName();
	//Assert.assertTrue(text.contains("Mamta"));
	if(text.equalsIgnoreCase(cnftext))
	{
		
		Assert.assertTrue(true);
	}
	else {
		//getScreenShot(driver, "verifyAccount");
		Assert.assertTrue(false);
	}
	//mp.ClickOnlogoff();
	
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
				String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


				int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
				int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
			

				String data[][]=new String[ttlRows-1][ttlColumns];

				for(int i=1;i<ttlRows;i++)//rows =1,2
				{
					for(int j=0;j<ttlColumns;j++)//col=0, 1,2
					{

						data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
					}

				}
				return data;
	}
	
	
		
	
	
	

}
