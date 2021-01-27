package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// we have to define OR or Page Factory of Login class
	// Annotation @FindBy
	//WebElement email= @FindBy(name="email");// driver.findelement(By.name("email"))
	
	@FindBy(name="email")
	 WebElement username;
	
	@FindBy(name="password")
	
	WebElement password;
	@FindBy(xpath="//div[text()= 'Login']")
	WebElement loginBtn;
	
    @FindBy(xpath="//a[@title='register on freecrm.com']//span[text()=' sign up']")
	
	WebElement SignUpBtn;
	
	@FindBy(xpath="//a[@title='free crm home'and @class='brand-name'] //span[text()='free']")
	
	WebElement logoTitle;

	
	// How to initialize the Page Objects using Page Factory
	
	public LoginPage()  // constructor
	{
		PageFactory.initElements(driver, this);//this means current class object.
		// In current class object all the variables email, password, logbtn vailable.
		// this is pointing to current class object
	}
	
	
	// Actions or features available on the page
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return logoTitle.isDisplayed();
	}
	
	public HomePage login(String us, String pass)
	
	{
		username.sendKeys(us);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();  // will return HomePage class object.HomePAge class will be landing page
	}
	

}
