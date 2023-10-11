package com.wipro.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wipro.registration.ExcelSheetRead;
import com.wipro.registration.Register;
import com.wipro.testbase.Drivers;
import com.wipro.utilities.ExtentReport;
import com.wipro.utilities.ReadMessage;
import com.wipro.utilities.ScreenShot;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest extends Drivers {
	
	ExcelSheetRead excelData;
	ExtentTest regtest;
	int row;
	int cloumn;
	int sheetIndex=0;
	Register register;
	ReadMessage message = new ReadMessage();
	ScreenShot screenshot= new ScreenShot();
	
	@DataProvider(name="ExcelSheetRead")
	public Object[][] dataReader() throws IOException{
		excelData=new ExcelSheetRead("REGISTER.xlsx" ,"/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/testdata/REGISTER.xlsx");
		row=excelData.RowCount(sheetIndex);
		
		cloumn = excelData.ColumnCount(sheetIndex);
		System.out.println(row);
		System.out.println(cloumn);
		Object[][] registerData = new Object[row-1][cloumn];
		for(int i =1; i<row; i++) {
			for(int j=0;j<cloumn;j++) {
				registerData[i-1][j]=excelData.getRegData(sheetIndex, i, j);
			}
		}
		return registerData;
		
	}

	@Test(dataProvider = "ExcelSheetRead")
	public void registerData(String FirstName,String LastName, String Email, String Password, String confirmPassword) throws InterruptedException,  IOException {
	register = new Register(driver);
	regtest = ExtentReport.extents.createTest("register");
	String regPageTitle =register.getPageTitle();
	AssertJUnit.assertEquals(regPageTitle, "nopCommerce demo store");
	register.register(FirstName, LastName, Email, Password, confirmPassword);
	Thread.sleep(1000);
	screenshot.takeScreenshots(driver, "Regsuccess.png");
	message.readData("Registration message:" + register.successMessage(),true);
	register.afterRegister();
	Thread.sleep(2000);
	regtest.log(Status.PASS,"Account registered successfully!");
	//System.out.println();
	
}
}
