package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[text()='Milu kumari']")
	WebElement userNamelabel;
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement Deals;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement Tasks;
	
	@FindBy(xpath="//i[@class='plus inverted icon']")
	WebElement createNewContact;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyUserName()
	
	{
	//	driver.switchTo().frame(0);// create a utilities in TestUtil class
		return userNamelabel.isDisplayed();
	}
	
	public ContactsPage clickOnContacts()
	{
		Actions action= new Actions(driver);
		action.moveToElement(contacts).build().perform();// It will move to contacts
		contacts.click();
		return new ContactsPage();// Return ContactPageObject
	}
	public DealsPage clickOnDeals()
	{
		Deals.click();
		return new DealsPage();// DealPage will be landing page
	}
	public void newContactLink()
	{
		Actions action= new Actions(driver);
		action.moveToElement(contacts).build().perform();// It will move to contacts
		createNewContact.click();
		
		
	}

}
