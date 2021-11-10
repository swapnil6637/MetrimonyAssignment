package com.matrimony.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarathiMatrimonyPanel2Page {
	
	WebDriver driver;
	
	public MarathiMatrimonyPanel2Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy (xpath = "//h2[contains(text(),'Now some basic details')]")
	WebElement panel2Heading;
	
	@FindBy (xpath = "//div[contains(@class,'mother_tongue_selector')]//div")
	WebElement communityTxt;
	
	public String getPageHeading(){
	
		panel2Heading.isDisplayed();
		return panel2Heading.getText();
		
	}
	
	public String getCommunityText(){
		
		communityTxt.isDisplayed();
		return communityTxt.getText();
		
	}
	
	public void enterBasicDetails(){
		
		
	}
	
	

}
