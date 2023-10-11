package com.wipro.testcases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wipro.registration.ExcelSheetRead;
import com.wipro.registration.Login;

import com.wipro.testbase.Drivers;
import com.wipro.utilities.ExtentReport;
import com.wipro.utilities.ReadMessage;
import com.wipro.utilities.ScreenShot;


public class LoginTest extends Drivers {
	

	    ExcelSheetRead excelReader;
	    ExtentTest logtest;

	    int row,column,sheetindexlogin=0;
	    Login login;
	    ReadMessage message = new ReadMessage();
	    ScreenShot screenshot = new ScreenShot();

	    

	    @DataProvider(name = "ExcelSheetRead")

	    public Object[][] datareader() throws IOException{

	        excelReader = new ExcelSheetRead("LOGIN.xlsx","/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/testdata/LOGIN.xlsx");
	        row = excelReader.RowCount(sheetindexlogin);
	        column = excelReader.ColumnCount(sheetindexlogin);
	        Object[][] loginAndAddress = new Object[row-1][column];
	        for(int i=1;i<row;i++) {
	            for(int j=0;j<column;j++) {
	                loginAndAddress[i-1][j]=excelReader.getRegData(sheetindexlogin,i,j);
	       
	            }
	        }return loginAndAddress;

	    }

	    @Test(dataProvider = "ExcelSheetRead")

	    public void login(String email_value, String password_value, String firstname, String lastname, String email, String company, String country, String state, String city, String address1, String address2, String zip, String phonenumber, String faxnumber) throws IOException, InterruptedException {

	        login = new Login(driver);
	        logtest = ExtentReport.extents.createTest("login");
	        String loginpageTitle = login.getpagetitle();
	        AssertJUnit.assertEquals(loginpageTitle,"nopCommerce demo store");
	        login.login1(email_value, password_value);
	        screenshot.takeScreenshots(driver,"login.png");
	        login.loginaddress(firstname,lastname,email,company,country,state,city,address1,address2,zip,phonenumber,faxnumber);
	        System.out.println(login.getmessage());
	        message.readData("Address:"+login.getmessage(), true);
	        screenshot.takeScreenshots(driver,"loginaddress.png");
	        login.logout();
	        screenshot.takeScreenshots(driver,"loginlogout.png");
	        logtest.log(Status.PASS,"Account logged in and address added successfully!");

	    }

	}

	

