package com.wipro.menu;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.wipro.registration.MenuLink;
import com.wipro.testbase.Drivers;
import com.wipro.utilities.*;

public class MenuStepDefinition {

		static MenuLink menu;
		static Drivers drivers;
		static WebDriver driver;
		ReadMessage message = new ReadMessage();
		ScreenShot ScreenShot = new ScreenShot();
		
		@BeforeMethod
		@BeforeAll
		public static void setUp() throws InterruptedException, IOException {
			drivers = new Drivers();
			drivers.driverSetup();
			driver = Drivers.driver;
			menu = new MenuLink(driver);
		}
		
		@Given("User is in the Home Page")
		public void user_is_in_the_home_page() throws InterruptedException {
			AssertJUnit.assertEquals(menu.getPageTitle(),"nopCommerce demo store");
			Thread.sleep(2000);
		}
		@Given("Click on the login link")
		public void click_on_the_login_link() throws InterruptedException{
			menu.Clicklogin();
			Thread.sleep(2000);
		}
		
		@When("User enters the Email and Password")
		public void user_enter_the_email_and_password(io.cucumber.datatable.DataTable dataTable) throws InterruptedException{
			menu.setEmail(dataTable.cell(0, 1));
			menu.setPassword(dataTable.cell(1, 1));
		}
		@When("Click on the login button")
		public void click_on_the_login_button() throws InterruptedException {
			menu.Clickloginbutton();
			Thread.sleep(2000);
		}
		@Then("User should navigate to home page after login")
		public void user_should_navigate_to_home_page_after_login() throws InterruptedException{
			
			Thread.sleep(2000);
		}
		
		@Given("User is in home page after login")
		public void user_is_in_home_page_after_login() throws InterruptedException{
			
			Thread.sleep(2000);
		}
		@And("Click on each link one after other")
		public void click_on_each__link_one_after_one() throws IOException, InterruptedException {
			message.readData("menu list: ", true);
			for(int i=0;i<menu.getsize();i++) {
				message.readData(i+1+"." +menu.getMenu().get(i).getText(), true);
			}
			message.readData("menu size: "+menu.getsize(), true);
			menu.clickComputers();
			ScreenShot.takeScreenshots(driver, "ssComputer.png");
			Thread.sleep(2000);
			
			menu.clickelectronics();
			ScreenShot.takeScreenshots(driver, "ssElectronics.png");
			Thread.sleep(2000);
			
			menu.clickapparels();
			ScreenShot.takeScreenshots(driver, "ssapparel.png");
			Thread.sleep(2000);
			
			menu.clickdigital();
			ScreenShot.takeScreenshots(driver, "ssdigital.png");
			Thread.sleep(2000);
			
			menu.clickbook();
			ScreenShot.takeScreenshots(driver,"ssbook.png");
			Thread.sleep(2000);
			
			menu.clickjewelry();
			ScreenShot.takeScreenshots(driver,"ssjewelry.png");
			Thread.sleep(2000);
			
			menu.clickGiftcard();
			ScreenShot.takeScreenshots(driver, "ssgift.png");
			Thread.sleep(2000);
		}
		
		@And("Click on logout button")
		public void click_on_logout_button() throws InterruptedException{
			menu.clickLogout();
			Thread.sleep(2000);
		}
		
		@Then("User navigate to home page")
		public void user_navigate_to_home_page() throws IOException {
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			ScreenShot.takeScreenshots(driver, "sslogout.png");
			
		}
		
		
}
