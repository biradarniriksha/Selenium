package com.wipro.registration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuLink {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement loginlink;
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailid;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement loginbutton;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']/li")
	List<WebElement> menu;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
	WebElement computers;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	WebElement electronics;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
	WebElement apparel;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
	WebElement digital;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
	WebElement books;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
	WebElement jewelry;
	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
	WebElement gift;
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logout;



public  MenuLink(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String getPageTitle() {
	return driver.getTitle();
}
public void Clicklogin() {
	loginlink.click();
}
public void setEmail(String Email) {
	emailid.sendKeys(Email);
}
public void setPassword(String Password) {
	password.sendKeys(Password);
}
public void Clickloginbutton() {
	loginbutton.click();
}
public List<WebElement> getMenu(){
	return menu;
}
public int getsize() {
	return menu.size();
}
public void clickComputers() {
	computers.click();
}
public void clickelectronics() {
	electronics.click();
}
public void clickapparels() {
	apparel.click();
}
public void clickdigital() {
	digital.click();
}
public void clickbook() {
	books.click();
}
public void clickjewelry() {
	jewelry.click();
}
public void clickGiftcard() {
	gift.click();
}
public void clickLogout() {
	logout.click();
}
public String logout() {
	return logout.getText();
}
}
