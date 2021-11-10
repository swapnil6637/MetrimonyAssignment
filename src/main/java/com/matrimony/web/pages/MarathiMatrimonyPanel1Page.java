package com.matrimony.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarathiMatrimonyPanel1Page {
	
	WebDriver driver;

	public MarathiMatrimonyPanel1Page(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Begin')]")
	WebElement letsBegin;
	
	@FindBy(xpath = "//h2[contains(text(),'set up your account, while')]")
	WebElement letsSetupYourAccountTxt;
	
	@FindBy(name = "email")
	WebElement emailIdEntryField;
	
	@FindBy(name= "password1")
	WebElement passwordEntryField;
	
	@FindBy(xpath = "//div[text()='Select']")
	WebElement createProfileForDropdown;
	
	@FindBy (xpath = "//button[text()='Next' and @type='submit']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	WebElement maleRadioBtn;
	
	@FindBy(xpath = "//label[contains(text(),'Female')]")
	WebElement femaleRadioBtn;
	
	
	
	public String getPageTitle(){
		
		letsBegin.isDisplayed();
		return driver.getTitle();

	}
	
	public void enterLoginCredentials(String email, String password, String profileFor, String gender){
		
		letsBegin.click();
		
		letsSetupYourAccountTxt.isDisplayed();
		
		emailIdEntryField.sendKeys(email);
		passwordEntryField.sendKeys(password);
		
		createProfileForDropdown.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		driver.findElement(By.xpath("//div[text()='"+profileFor+"']")).click();
		
		if(profileFor.equalsIgnoreCase("Self") || profileFor.equalsIgnoreCase("Friend") 
				|| profileFor.equalsIgnoreCase("Relative")){
		
			selectGender(gender);
		}
		
		nextBtn.click();
		
	}

	public void selectGender(String gender){
		
		maleRadioBtn.isDisplayed();
		
		if(gender.equalsIgnoreCase("male")){
			maleRadioBtn.click();
		}else if (gender.equalsIgnoreCase("female")) {
			femaleRadioBtn.click();			
		}
		
	}
	
	
	
	
	
	
	
	

}
