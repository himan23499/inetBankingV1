package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddAccountPage {
		WebDriver ldriver;
		public AddAccountPage(WebDriver rdriver) {
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		
		@FindBy(xpath="//ul[@class='menusubnav']/li[5]/a")
		@CacheLookup
		WebElement lnkAddAcc;
		
		@FindBy(name="cusid")
		@CacheLookup
		WebElement txtCustId;
		
		
		@FindBy(name="selaccount")
		@CacheLookup
		WebElement txtSelac;

		
		
		@FindBy(name="inideposit")
		@CacheLookup
		WebElement txtInDeposit;
		
		
		
		
		@FindBy(name="button2")
		@CacheLookup
		WebElement btnSubmit;
		
		
		
		public void clickAddNewAccount() {
			lnkAddAcc.click();
		}
		
		public void addCustId(String custId) {
			txtCustId.sendKeys(custId);
		}
		
		public void selectAcType(String Acc) {
			Select s=new Select(txtSelac);
			s.selectByValue(Acc);
		}
		public void addIniDeposit(String iniDepo) {
			txtInDeposit.sendKeys(iniDepo);
		}
		public void clckSubmit() {
			btnSubmit.click();
		}
}
