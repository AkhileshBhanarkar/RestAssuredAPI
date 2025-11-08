package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropertyFile {
	
	public Properties properties;
	public FileInputStream fis;
	
	//--------------------------------
    // Summary:
	// 		Reading the values from 
	//		property file.
	//--------------------------------	
	public ReadingPropertyFile() {
		try {
			fis = new FileInputStream("C:\\Users\\akhileshbhanarkar\\eclipse-workspace\\RestAPIAssignment\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//--------------------------------
    // Summary:
	// 		Returning the values from 
	//		property file.
	// Params:
	//		key.
	//--------------------------------
	public String getProperty(String key) throws Exception {
		return properties.getProperty(key);
	}


}
