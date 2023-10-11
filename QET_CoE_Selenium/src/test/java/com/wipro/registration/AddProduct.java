package com.wipro.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	WebDriver driver;

    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement Login;
    @FindBy(xpath = "//input[@class='email']")
    WebElement Email;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement Password;
    @FindBy(xpath = "//button[normalize-space()='Log in']")
    WebElement LoginButton;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computers;
    @FindBy(xpath = "//li[@class='active last']//a[normalize-space()='Desktops']")
    WebElement desktops;
    @FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'Digital Storm VANQUISH 3 Custom Performance PC')]")
    WebElement Vanquish3;
    @FindBy(xpath = "//h1[normalize-space()='Digital Storm VANQUISH 3 Custom Performance PC']")
    WebElement productname;
    @FindBy(xpath = "//span[@id='price-value-2']")
    WebElement productprice;
    @FindBy(xpath = "//button[@id='add-to-cart-button-2']")
    WebElement addtocart;
    @FindBy(xpath = "//p[@class='content']")
    WebElement cartmessage;
    @FindBy(xpath = "//span[@class='close']")
    WebElement messagedismiss;
    @FindBy(xpath = "//span[@class='cart-label']")
    WebElement shoppingcart;
    @FindBy(xpath = "//input[@id='termsofservice']")
    WebElement condition;
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkout;
    @FindBy(xpath = "//button[@onclick='Billing.save()']")
    WebElement addresscontinue;
    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    WebElement shippingcontinue;
    @FindBy(xpath = "//button[@class='button-1 payment-method-next-step-button']")
    WebElement paymentcontinue;
    @FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
    WebElement infocontinue;
    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    WebElement confirm;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement confirmaftercontinue;
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logout;


    public AddProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
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
    public void clickComputer() {
        computers.click();
    }
    public void clickDesktops() {
        desktops.click();
    }
    public void clickVanquish3() {
        Vanquish3.click();
    }
    public String getProductname() {
        return productname.getText();
    }
    public String getProductprice() {
        return productprice.getText();
    }
    public void clickAddtocart() {
        addtocart.click();
    }
    public String getcartmessage() {
        return cartmessage.getText();
    }
    public void clickalertmsg() {
        messagedismiss.click();    
    }
    public void clickshoppingcart() {
        shoppingcart.click();
    }
    public void clickCondition() {
        condition.click();
    }
    public void clickCheckout() {
        checkout.click();
    }
    public void clickAddresscontinue() {
        addresscontinue.click();
    }
    public void clickShippingcontinue() {
        shippingcontinue.click();
    }
    public void clickPaymentcontinue() {
        paymentcontinue.click();
    }
    public void clickInformationcontinue() {
        infocontinue.click();
    }
    public void clickConfirm() {
        confirm.click();
    }
    public void clickcontinueConfirm() {
        confirmaftercontinue.click();
    }
    public void clickLogout() {
        logout.click();
    }

    public void login(String emailvalue,String passwordvalue) throws InterruptedException {
        this.ClickLogin();
        Thread.sleep(1000);
        this.setEmail(emailvalue);
        this.setPassword(passwordvalue);
        Thread.sleep(1000);
        this.ClickLoginButton();
        Thread.sleep(1000);
    }


 

    public void productDisplay() throws InterruptedException {

        this.clickComputer();
        Thread.sleep(3000);
        this.clickDesktops();
        Thread.sleep(3000);
        this.clickVanquish3();
        Thread.sleep(3000);
    }

    public void addproduct() throws InterruptedException {

        this.clickAddtocart();
        Thread.sleep(3000);
        this.clickalertmsg();
        Thread.sleep(3000);
        this.clickshoppingcart();
        Thread.sleep(3000);
        this.clickCondition();
        Thread.sleep(3000);
        this.clickCheckout();
        Thread.sleep(3000);
        this.clickAddresscontinue();
        Thread.sleep(3000);
        this.clickShippingcontinue();
        Thread.sleep(3000);
        this.clickPaymentcontinue();
        Thread.sleep(3000);
        this.clickInformationcontinue();
        Thread.sleep(3000);
        this.clickConfirm();
        Thread.sleep(3000);
        this.clickcontinueConfirm();
        Thread.sleep(3000);

    }

    public void logout() throws InterruptedException {
        this.clickLogout();
        Thread.sleep(3000);

}
}
