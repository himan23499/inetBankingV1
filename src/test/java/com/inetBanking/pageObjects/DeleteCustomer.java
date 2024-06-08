package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer {

		WebDriver ldriver;
		public  DeleteCustomer(WebDriver rdriver) {
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//ul[@class='menusubnav']/li[4]/a")
		@CacheLookup
		WebElement lnkDeletCust;
		
		@FindBy(name="cusid")
		@CacheLookup
		WebElement txtCustId;
		
		@FindBy(name="AccSubmit")
		@CacheLookup
		WebElement btnAccDel;
		
		public void clickDeleteAccount() {
			lnkDeletCust.click();
		}
		
		public void addCustId(String custId) {
			txtCustId.sendKeys(custId);
		}
		public void clckSubmit() {
			btnAccDel.click();
		}
}
