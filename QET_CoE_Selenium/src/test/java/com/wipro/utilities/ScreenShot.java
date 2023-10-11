package com.wipro.utilities;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public void takeScreenshots(WebDriver driver, String filePath) throws IOException {
	
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File scrFile=screenshot.getScreenshotAs(OutputType.FILE);
		File destFile=new File("/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/screenshots/"+filePath);
		FileUtils.copyFile(scrFile, destFile);
		
	}

	
}
