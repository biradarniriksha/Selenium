package com.wipro.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
		public static ExtentReports extents;
		public static ExtentHtmlReporter htmlextents;

		public static void Report(String path) {
			htmlextents = new ExtentHtmlReporter("/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/report/test.html"+path+".html");;
			extents = new ExtentReports();
			extents.attachReporter(htmlextents);
		}
		public static void close() {
			extents.flush();
		}

	}

