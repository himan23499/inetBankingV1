package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//	@FindBy(how=How.XPATH,using="//html/body/div[3]/div/ul/li[2]/a")
//	@CacheLookup
//	WebElement lnkAddNewCustomer;
	
	@FindBy(xpath="//html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement rdGender;
	
	@CacheLookup
	@FindBy(id="dob")
	WebElement txtdob;
	
//	@CacheLookup
//	@FindBy(how=How.ID_OR_NAME,using="dob")
//	WebElement txtdob;
	
//	@CacheLookup
//	@FindBy(how=How.NAME,using="addr")
//	WebElement txtaddress;
	
	@CacheLookup
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@CacheLookup
	@FindBy(name="city")
	WebElement txtcity;
	
	@CacheLookup
	@FindBy(name="state")
	WebElement txtstate;
	
	@CacheLookup
	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@CacheLookup
	@FindBy(name="telephoneno")
	WebElement txttelephoneno;
	
	@CacheLookup
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement txtpassword;
	@CacheLookup
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	
	@FindBy(xpath="//table[@id='customer']/tbody/tr[4]/td[2]")
	@CacheLookup
	WebElement getCustId;
	
	
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	public void custgender(String cgender) {
		rdGender.click();
	}
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	public void custsubmit() {
		btnSubmit.click();
	}
	
	public String getCustId() {
		
		return getCustId.getText();
	}
	
	
}
