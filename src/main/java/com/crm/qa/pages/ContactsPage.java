package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contacts;
//	@FindBy(xpath="a[text()='mila yuuii kumar']//parent::td//preceding-sibling::td//div//input[@name='id']")
//	WebElement contactLablel; // this is secific to this contact. if i have to click on other contact.I have create again xpath
//	It is not compulsory to define page factory for all the elements.
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	@FindBy(name="last_name")
	WebElement lastname;
	@FindBy(name="middle_name")
	WebElement middlename;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactLabel()
	{
		return contacts.isDisplayed();
	}
	
	public void selectContact(String name) 
	{
	    driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div//input[@name='id']")).click();
	}
	
	public void createNewContact(String Name, String Lastname, String Middlename)
	{
		// Select select = new Select(driver.findElement(By.xpath("//input[@name='name']")));
//		Select select = new Select(name);
//		select.deselectByVisibleText(Name);
		name.sendKeys(Name);
		lastname.sendKeys(Lastname);
		middlename.sendKeys(Middlename);
	}
}
