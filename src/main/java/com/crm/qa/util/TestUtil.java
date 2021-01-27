package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.TakesScreenshot;
import org.openxml4j.exceptions.InvalidFormatException;

import com.crm.qa.base.TestBase;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;


public class TestUtil extends TestBase {
	
	
	public static long Page_Load_TimeOut=10;
	public static long Implicit_Wait=10; // public static variables
    
	
	public void switchToFrame()
	{
		driver.switchTo().frame(0);
	}
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\milun\\eclipse-workspace\\Selenium_H2K1\\MIlanTestProject\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRM_testdata.xlsx";

	
	
// Returning 2 dimensional Array. Will iterate the sheet based on rows and columns
	static Workbook book;
	static Sheet sheet;
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest()
	{
		 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("/Users/milun/eclipse-workspace/Selenium_H2K1/JavaTrainingSession/src/SeleniumSessions/google.png"));
	}
	
	
}
