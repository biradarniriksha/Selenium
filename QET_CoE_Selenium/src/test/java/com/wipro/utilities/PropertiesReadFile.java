package com.wipro.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReadFile  {
		
		public Properties getProperties() throws IOException {
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/config/config.properties");
		properties.load(file);
		
		return properties;
		
	}
}
