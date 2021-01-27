package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
// test case should be separated- independent to each other
// before each test case launch the browser and login
//@test- execute the test case
// after each testcase close the browser
public class HomePageTest extends TestBase{
	
	 HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		intialization(); // Call TestBase Class method
		testutil = new TestUtil();
		loginpage= new LoginPage();
		
		  homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));// will return HomePage class object
		contactspage = new ContactsPage();	
	}
	@Test
	public void validateHomePageTitleTest()
	{
		String S= homepage.validateHomePageTitle();
		Assert.assertEquals(S, "Cogmento CRM","Title Not Match");
		
	}
	@Test
	public void verifyuserNameTest()
	{
		testutil.switchToFrame();
		boolean test=homepage.verifyUserName();
		Assert.assertTrue(test);
	}
	@Test
	public void clickOnContactTest()
	{
		
	contactspage=homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		     driver.quit();
	//driver.quit();
	}
	

}
