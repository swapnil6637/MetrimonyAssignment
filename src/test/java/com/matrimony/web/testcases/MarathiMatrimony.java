package com.matrimony.web.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.matrimony.web.base.BaseClass;
import com.matrimony.web.pages.MarathiMatrimonyPanel1Page;
import com.matrimony.web.pages.MarathiMatrimonyPanel2Page;
import com.matrimony.web.utilityFunctions.GetTestData;

public class MarathiMatrimony extends BaseClass{

	
	@DataProvider(parallel = true)
	public Object[][] getTestData() {
		Object data[][] = GetTestData.getTestData("MarathiMatrimony");
		return data;	
	}
	
	@Test(priority = 1, description = "Marathi Matrimony" ,dataProvider = "getTestData")
	public void marathiMatrimony(String emailId, String password, String profileFor, String gender) {
		
		test = extent.createTest("Marathi Matrimony");
		test.info("Starting test Marathi Matrimony");
		
		MarathiMatrimonyPanel1Page panel1Page = new MarathiMatrimonyPanel1Page(driver);
		
		String homePageTitle = panel1Page.getPageTitle();
		Assert.assertEquals(homePageTitle, "Marathi Matrimony & Matrimonial Service by MarathiShaadi.com");
		test.info("Verified Page Title");
		panel1Page.enterLoginCredentials(emailId, password, profileFor,gender);
		test.info("Panel1 details entered");

		MarathiMatrimonyPanel2Page panel2Page = new MarathiMatrimonyPanel2Page(driver);
		test.info("Panel2 details Started");		
		String panel2Heading = panel2Page.getPageHeading();
		Assert.assertEquals(panel2Heading, "Great! Now some basic details");
		
		test.info("Panel2 Displayed Completely");	
		
		String community = panel2Page.getCommunityText();
		test.info("Getting the Community Text");
		Assert.assertEquals(community, "Marathi");
		test.info("Community Text Verified Successfully");
		
	}
	

}
