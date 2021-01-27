package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName="contacts";
	// We are using hybrid framework all the classes and test cases should be independent
	
	public ContactsPageTest()
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
		  testutil.switchToFrame();
		 contactspage= homepage.clickOnContacts();
	}
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		 boolean A= contactspage.verifyContactLabel();
		  Assert.assertTrue(A);
	}
	@Test(priority=2)
	public void selectcontactsTest()
	{
		contactspage.selectContact("mila yuuii kumar");
	}
	@Test(priority=2) // if two tescase have same priority in that case TestNG will decide which one execute first
	public void selectMultipleContactsTest()
	{
		contactspage.selectContact("mila yuuii kumar");
		contactspage.selectContact("RajaKumar ert bannu");
	}
	@DataProvider // datProvider fetching the data from data sheet
	public Object[][] getTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test( priority=3, dataProvider="getTestData")
	public void validatecreateNewContactTest( String Name, String Lastname, String Middlename) // Now you can pass data provider name
	{
		homepage.newContactLink();
		contactspage.createNewContact(Name, Lastname,Middlename);
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		     driver.quit();
	//driver.quit();
	}

}
