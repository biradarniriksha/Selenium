package com.wipro.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement Login;
	@FindBy(xpath="//input[@class='email']")
	WebElement Email;
	@FindBy(xpath="//input[@class='password']")
	WebElement Password;
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement LoginButton;
	@FindBy(xpath="//a[@class='ico-account']")
	WebElement Account;
	@FindBy(xpath="//li[@class='customer-addresses inactive']//a[normalize-space()='Addresses']")
	WebElement Address;
	@FindBy(xpath="//button[normalize-space()='Add new']")
	WebElement AddAddress;
	@FindBy(xpath="//input[@id='Address_FirstName']")
	WebElement FirstName;
	@FindBy(xpath="//input[@id='Address_LastName']")
	WebElement LastName;
	@FindBy(xpath="//input[@id='Address_Email']")
	WebElement EmailId;
	@FindBy(xpath="//input[@id='Address_Company']")
	WebElement Company;
	@FindBy(xpath="//select[@id='Address_CountryId']")
	WebElement Country;
	@FindBy(xpath="//select[@id='Address_StateProvinceId']")
	WebElement StateProvince;
	@FindBy(xpath="//input[@id='Address_City']")
	WebElement City;
	@FindBy(xpath="//input[@id='Address_Address1']")
	WebElement Address1;
	@FindBy(xpath="//input[@id='Address_Address2']")
	WebElement Address2;
	@FindBy(xpath="//input[@id='Address_ZipPostalCode']")
	WebElement ZipPostalCode;
	@FindBy(xpath="//input[@id='Address_PhoneNumber']")
	WebElement PhoneNumber;
	@FindBy(xpath="//input[@id='Address_FaxNumber']")
	WebElement FaxNumber;
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement SaveButton;
	@FindBy(xpath="//a[@class='ico-logout']")
	WebElement logout;
	@FindBy(xpath="//p[@class='content']")
	WebElement Message;
	@FindBy(xpath="//span[@title='Close']")
	WebElement Alertdismiss;
	
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public void ClickLogin() {
		Login.click();
	}
	public void setEmail(String emailvalue) {
		Email.sendKeys(emailvalue);
	}
	public void setPassword(String passwordvalue) {
		Password.sendKeys(passwordvalue);
	}
	public void ClickLoginButton() {
		LoginButton.click();
	}
	public void ClickAccount() {
		Account.click();
	}
	public void ClickAddress() {
		Address.click();
	}
	public void ClickAddAddress() {
		AddAddress.click();
	}
	public void setFirstname(String firstnameValue) {
		FirstName.sendKeys(firstnameValue);
	}
	public void setLastname(String lastnameValue) {
		LastName.sendKeys(lastnameValue);
	}
	public void setEmailid(String emailidValue) {
		EmailId.sendKeys(emailidValue);
	}
	public void setCompany(String companyValue) {
		Company.sendKeys(companyValue);
	}
	public void setCountry(String countryValue ) {
		Select country=new Select(Country);
		country.selectByVisibleText(countryValue);
	}
	public void setState(String stateValue) {
		Select state=new Select(StateProvince);
		if(Country.getText().equals("United States")) {
			state.selectByVisibleText(stateValue);
		}else{
			state.selectByVisibleText("Other");
		}
		
	}
	public void setCity(String cityValue) {
		City.sendKeys(cityValue);
	}
	public void setAddress1(String AddressValue1) {
		Address1.sendKeys(AddressValue1);
	}
	public void setAddress2(String AddressValue2) {
		Address2.sendKeys(AddressValue2);
	}
	public void setZip(String ZipValue) {
		ZipPostalCode.sendKeys(ZipValue);
		
	}
	public void setphonenumber(String PhonenumberValue) {
		PhoneNumber.sendKeys(PhonenumberValue);
		
	}
	public void setfaxnumber(String faxnumbervalue) {
		FaxNumber.sendKeys(faxnumbervalue);
	}
	public void Clicksave() {
		SaveButton.click();
	}
	public String getpagetitle() {
		return driver.getTitle();
	}
	public void Clickalertdismiss() {
		Alertdismiss.click();
	}
	public void ClickLogout() {
		logout.click();
	}
	public String getmessage() {
		return Message.getText();
	}
	
	public void loginaddress(String firstname, String lastname, String emailid, String company, String country, String state,String city, String address1, String address2,String Zipvalue, String phonenumber, String faxnumber) throws InterruptedException {
		Thread.sleep(3000);
		this.ClickAccount();
		Thread.sleep(2000);
		this.ClickAddress();
		Thread.sleep(2000);
		this.ClickAddAddress();
		Thread.sleep(3000);
		this.setFirstname(firstname);
		Thread.sleep(3000);
		this.setLastname(lastname);
		Thread.sleep(3000);
		this.setEmailid(emailid);
		Thread.sleep(3000);
		this.setCompany(company);
		Thread.sleep(3000);
		this.setCountry(country);
		Thread.sleep(3000);
		this.setState(state);
		Thread.sleep(3000);
		this.setCity(city);
		Thread.sleep(3000);
		this.setAddress1(address1);
		this.setAddress2(address2);
		this.setZip(Zipvalue);
		this.setphonenumber(phonenumber);
		this.setfaxnumber(faxnumber);
		Thread.sleep(3000);
		this.Clicksave();
		Thread.sleep(3000);
		
		
	}
	public void login1(String emailvalue, String passwordvalue) throws InterruptedException {
		this.ClickLogin();
		Thread.sleep(3000);
		this.setEmail(emailvalue);
		Thread.sleep(3000);
		this.setPassword(passwordvalue);
		Thread.sleep(3000);
		this.ClickLoginButton();
		Thread.sleep(3000);
	}
	public void logout() throws InterruptedException {	
		this.Clickalertdismiss();
		Thread.sleep(3000);
		this.ClickLogout();
	}

}
