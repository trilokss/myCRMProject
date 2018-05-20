package com.testdemo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LeadsPage;
import com.crm.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	LeadsPage leadspage;
	public HomePageTest() {super();}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		 loginpage=new LoginPage();
		 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void homePageTitleTest()
	{
		String title= homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	}
	
	@Test
	public void leadsLinkTest() {
		leadspage =	homepage.clickOnLeadsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
