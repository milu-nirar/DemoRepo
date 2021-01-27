package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase {
	// Page Factory or Object Repository
	
	@FindBy(xpath="//a[@title='register on freecrm.com']//span[text()=' sign up']")
	
	WebElement SignUpBtn;
	
	@FindBy(xpath="//a[@title='free crm home'and @class='brand-name'] //span[text()='free']")
	
	WebElement logoTitle;

}
