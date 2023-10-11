package com.wipro.registration;
import org.openqa.selenium.*;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;

public class Register {
	WebDriver driver;
	
	//@FindBy(how = How.LINK_TEXT, using = "REGISTER")
	By Register = By.xpath("//a[@class='ico-register']");
	By FirstName = By.xpath("//input[@name='FirstName']");
	By LastName = By.xpath("//input[@name='LastName']");
	By Email = By.xpath("//input[@name='Email']");
	By Password = By.xpath("//input[@name='Password']");
	By ConfirmPassword  = By.xpath("//input[@name='ConfirmPassword']");
	By Submit = By.xpath("//button[@name='register-button']");
	By message = By.xpath("//div[@class='result']");
	By clickContinue = By.xpath("//a[@class='button-1 register-continue-button']");
	
	public Register(WebDriver driver) {
		this.driver = driver; 
	}
	public void RegisterClick() {
		driver.findElement(Register).click();
	}
public void setFirstName(String firstnamevalue) {
	driver.findElement(FirstName).sendKeys(firstnamevalue);
		
	}
public void setLastName(String lastnamevalue) {
	driver.findElement(LastName).sendKeys(lastnamevalue);
	
}
public void setEmail(String email) {
	driver.findElement(Email).sendKeys(email);
	
}
public void setPassword(String password) {
	driver.findElement(Password).sendKeys(password);
	
}
public void setConfirmPassword(String confirmPassword) {
	driver.findElement(ConfirmPassword).sendKeys(confirmPassword);
	
}
public void clickSubmit() {
	driver.findElement(Submit).click();
}
public String successMessage() {
	return driver.findElement(message).getText();
}
public void clickContinue() {
	driver.findElement(clickContinue).click();
}
public void register(String FirstName, String LastName,String Email,String Password,String confirmPassword) {
	this.RegisterClick();
	this.setFirstName(FirstName);
	this.setLastName(LastName);
	this.setEmail(Email);
	this.setPassword(Password);
	this.setConfirmPassword(confirmPassword);
	this.clickSubmit();
	
	
	
}
public String getPageTitle() {
	// TODO Auto-generated method stub
	String title = driver.getTitle();
	return title;
}
public void afterRegister() {
	// TODO Auto-generated method stub
	this.clickContinue();
	
}

}
