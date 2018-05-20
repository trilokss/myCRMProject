package com.testdemo;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		 loginpage=new LoginPage();
	}
	
	@Test
	public void loginPageLogoTest() {
		boolean flag=loginpage.validateCrmLogo();
		Assert.assertTrue(flag);
	}
	@Test
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
