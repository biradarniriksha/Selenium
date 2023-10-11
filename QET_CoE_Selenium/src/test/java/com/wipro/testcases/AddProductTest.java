package com.wipro.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;
import com.wipro.registration.AddProduct;
import com.wipro.registration.ExcelSheetRead;
import com.wipro.testbase.Drivers;
import com.wipro.utilities.*;

public class AddProductTest extends Drivers{
	ExcelSheetRead excelreader;
	ExtentTest test;
    int row,column,sheetindex=0;
    AddProduct cart;
    ReadMessage message = new ReadMessage();
    ScreenShot screenshot = new ScreenShot();

    @DataProvider(name = "ExcelSheetRead")
    public Object[][] datareader() throws IOException{
        excelreader = new ExcelSheetRead("ALOGIN.xlsx","/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/testdata/ALOGIN.xlsx");
        row = excelreader.RowCount(sheetindex);
        column = excelreader.ColumnCount(sheetindex);
        Object[][] Addproduct = new Object[row-1][column];
        for(int i=1;i<row;i++) {
            for(int j=0;j<column;j++) {
                Addproduct[i-1][j]=excelreader.getRegData(sheetindex,i,j);
            }
        }return Addproduct;
    }
    @Test(dataProvider = "ExcelSheetRead")
    public void AddProductTo(String email, String password) throws InterruptedException, IOException {
        cart = new AddProduct(driver);
        test = ExtentReport.extents.createTest("add to cart and payment");
        cart.login(email,password);
        screenshot.takeScreenshots(driver, "AddToCart.png");
        cart.productDisplay();
        screenshot.takeScreenshots(driver, "ProductDisplay.png");
        message.readData("Product name: "+cart.getProductname(), true);
        message.readData("Product name: "+cart.getProductprice(), true);
        cart.addproduct();
        screenshot.takeScreenshots(driver, "Successor.png");
        cart.logout();
        screenshot.takeScreenshots(driver, "logout.png");
        test.log(Status.PASS,"Product added and payment successful!");
}
}