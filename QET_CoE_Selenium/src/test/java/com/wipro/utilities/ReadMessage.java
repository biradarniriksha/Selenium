package com.wipro.utilities;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class ReadMessage {
	File file = new File("/Users/NI20463611/Desktop/QET_CoE_Selenium/resources/testdata/message");
	public void readData(String message, boolean b) throws IOException {
		FileWriter fileWriter=new FileWriter(file,true);
		
		fileWriter.write(message);
		fileWriter.write("\r\n");
		fileWriter.close();
}
}
