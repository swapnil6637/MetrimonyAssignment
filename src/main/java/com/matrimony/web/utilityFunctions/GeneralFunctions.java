package com.matrimony.web.utilityFunctions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GeneralFunctions {
	
	/*
	 Includes functions to capture screenshot and get Current time
	 */
	public static String getScreenshot(WebDriver driver) throws IOException {
		  
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat customformat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date CurrentDate = new Date();
		return customformat.format(CurrentDate);
	}
	
	

}
