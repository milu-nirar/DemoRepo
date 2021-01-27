package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
  public static WebDriver driver; // Global Variable: child classes and everyone can access it
   public static Properties prop;
   public static EventFiringWebDriver e_Driver;
   public static WebEventListener eventListener;
	
	public TestBase() 

	 {
		prop= new Properties();
		
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\milun\\eclipse-workspace\\Selenium_H2K1\\MIlanTestProject\\src\\main\\java\\com\\crm\\qa\\cofig\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		} 
	public static void intialization()
	{
		 String browserName=prop.getProperty("browser");// read the properties
		 if(browserName.equals("chrome"))//browserName.startsWith("chrome")
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\milun\\Desktop\\Chrome driver version 88\\chromedriver.exe");// Set the property first
				driver= new ChromeDriver();
		 }
		 else if(browserName.equals("FF"))
		 {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\milun\\Dropbox\\Downloads\\chromedriver_win32 (3)\\geckodriver.exe");// Set the property first
				driver= new FirefoxDriver();
		 }
		 
		e_Driver= new EventFiringWebDriver(driver);
		 
		// Now create object of EventListenerHandler to register it with EventFiringWebDriver 
		eventListener= new WebEventListener();
		e_Driver.register(eventListener);
		driver=e_Driver;
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut, TimeUnit.SECONDS);// picking up the value from TestUtil class
		 // Static variable can be called directly by class name
		 driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		 driver.get( prop.getProperty("url"));
		
	}
	
		
     }


