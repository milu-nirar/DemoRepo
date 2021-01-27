package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();// will call TestBase(Parent) class constructor because I want to Initialize my properties also before initialization().
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization(); // Call TestBase Class method
		
		loginpage= new LoginPage(); // creating object
		
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String Title= loginpage.validateLoginPageTitle();
		Assert.assertEquals(Title, "#1 Free CRM customer relationship management software cloud","Not Matching Title");
	}
	@Test
	public void validateCRMImageTest()
	{
	boolean flag=loginpage.validateCRMImage();
	Assert.assertTrue(flag);
	//Assert.assertEquals(flag, "Free", "Not Matching CRM Image");
	}
	
	@Test
	public void loginTest()
	{
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		 
		     driver.quit();
//		driver.quit();
	}
	
	
	
	
	

}
