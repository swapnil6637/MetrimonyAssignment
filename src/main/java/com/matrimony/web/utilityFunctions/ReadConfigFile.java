package com.matrimony.web.utilityFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties properties;
	
	/* Includes functions to read config file */
	
	public ReadConfigFile(){
		
		FileInputStream file;
		try {
			file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
			properties = new Properties();
			properties.load(file);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error while reading config.properties file");
		}
	}
	
	public String readBrowserName(){
		return properties.getProperty("browser");
	}
	
	public String readUrl(){
		return properties.getProperty("url");
	}
	
	public String readImplicitlyWait(){
		return properties.getProperty("implicitlyWait");
	}
	
	public String readpageLoadTimeout(){
		return properties.getProperty("pageLoadTimeout");
	}
	
	public String readResultFilePath(){
		return properties.getProperty("resultFilePath");
	}
	

}
