package com.wipro.testbase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.wipro.utilities.ExtentReport;
import com.wipro.utilities.PropertiesReadFile;

public class Drivers {
	public static WebDriver driver;

    public Properties property;
    public PropertiesReadFile properties = new PropertiesReadFile();
    String path = "test";
    @BeforeSuite
    public void driverSetup() throws InterruptedException, IOException{
        property = properties.getProperties();
        if(property.getProperty("browser").equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/driverfiles/chromedriver");
            driver = new ChromeDriver();
        }

        else if(property.getProperty("browser").equals("edge"))
        {
            System.setProperty("webdriver.edge.driver", "/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/driverfiles/msedgedriver");
            driver = new EdgeDriver();
        }

        driver.get(property.getProperty("url"));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        ExtentReport.Report(path);

    }
    public WebDriver getDriver() {
        return driver;
    }

    @AfterSuite
    public void driverquit() {
        ExtentReport.close();
        driver.quit();
    }

	
//		protected WebDriver driver;
//		
//		@BeforeSuite
//		public void driverSetup() throws InterruptedException {
//			System.setProperty("webdriver.chrome.driver","/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/driverfiles/chromedriver");
//			driver = new ChromeDriver();
//			driver.get("https://demo.nopcommerce.com/");
//			driver.manage().window().maximize();
//			Thread.sleep(2000);
//		}
//		 @AfterSuite
//		 public void driverquit() {
//			 driver.quit();
//		 
//
//	}

}
