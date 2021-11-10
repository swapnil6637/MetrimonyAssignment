package com.matrimony.web.utilityFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	/*This class includes launch broswer , quit the browser & navigate to URL as mentioned in Config File*/
	
	public static WebDriver driver;
	
	static ReadConfigFile rd = new ReadConfigFile();
	
	public static WebDriver launchBrowser(){
		
		String browserName = rd.readBrowserName();
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/ChromeDriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else{
			System.out.println("Browser not found");
		}
		return driver;
	}
	
	public static void navigateToUrl(WebDriver driver){
		
		String url = rd.readUrl();
		long implicitlyWait = Long.parseLong(rd.readImplicitlyWait());
		long pageLoadTimeout = Long.parseLong(rd.readpageLoadTimeout());
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(implicitlyWait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
	
	}
	
	public static void quitBrowser(WebDriver driver){
		driver.quit();
	}
	
}