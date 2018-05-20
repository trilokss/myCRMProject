package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;
/* 
 ** @Auther Trilok
 */
public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Leads')]")
	WebElement leadsLink;
	
	@FindBy(xpath="//a[contains(text(),'Organizations')]")
	WebElement orgsLink;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement productsLink;
	
	
	//initialize page objects
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public LeadsPage clickOnLeadsLink() {
		leadsLink.click();
		return new LeadsPage(); 
	}
	public OrganizatinPage clickOnOrgsLink() {
		leadsLink.click();
		return new OrganizatinPage(); 
	}
	public ProductPage clickOnProductLink() {
		leadsLink.click();
		return new ProductPage(); 
	}
	
	
}
