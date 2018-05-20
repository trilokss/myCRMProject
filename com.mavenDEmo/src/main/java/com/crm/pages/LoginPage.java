package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {

	/*page factory, identify webelements of the login page*/
	
	@FindBy(name="user_name") WebElement username;
	
	@FindBy(name="user_password")WebElement password;
	
	@FindBy(id="submitButton") WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='test/logo/vtiger-crm-logo.gif']") WebElement crmLogo;
	
	
	/*initialize webelements/page objects*/
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public boolean validateCrmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	
}
