package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		logger.info("User name Provided");
		lp.setUserName(username);
		logger.info("Password Provided");
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		driver.navigate().back();
		Thread.sleep(3000);
		addcust.clickAddNewCustomer();
		logger.info("Providing Customer Details..");
		Thread.sleep(3000);
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("04", "12", "1999");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("MUM");
		addcust.custstate("MH");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("9768574737");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("Validation Started...");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
		
	}
	
	
}
