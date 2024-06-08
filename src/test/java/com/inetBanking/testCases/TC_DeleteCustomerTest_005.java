package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.DeleteCustomer;
import com.inetBanking.pageObjects.LoginPage;
public class TC_DeleteCustomerTest_005 extends BaseClass {
	String custId;
	
	@Test
	public void deleteCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		logger.info("User name Provided");
		lp.setUserName(username);
		logger.info("Password Provided");
		lp.setPassword(password);
		lp.clickSubmit();
		Thread.sleep(3000);
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Providing Customer Details..");
		addcust.custName("cgdhr");
		addcust.custgender("male");
		addcust.custdob("04", "12", "1999");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("MUM");
		addcust.custstate("MH");
		addcust.custpinno("543214");
		addcust.custtelephoneno("9768574737");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("432567");
		addcust.custsubmit();
		Thread.sleep(3000);
		logger.info("Validation Started...");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed");
			custId=addcust.getCustId();
			System.out.println(custId);
		}else {
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
		Thread.sleep(2000);
		DeleteCustomer dc = new DeleteCustomer(driver);
		dc.clickDeleteAccount();
		Thread.sleep(2000);
		dc.addCustId(custId);
		captureScreen(driver,"DelNewCustomer");
		dc.clckSubmit();
		
		driver.switchTo().alert().accept();
		System.out.println(driver.switchTo().alert().getText());
	}

}
