package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class LoginTest extends Base {
	
	LoginPage loginpage;
	HomePage homepage;
	ExcelReader excelreader = new ExcelReader();
	//ScreenshotCapture screenshot= new ScreenshotCapture();
	
    
	@Test(groups="Smoke")
	public void verifyLogin()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		String actualProfileName=homepage.getProfileName();
	    String expectedProfileName="admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		//screenshot.takeScreeshot(driver, "LoginImage");
		//System.out.println(GeneralUtility.getRandomName());
		
		
	}
	
	@Test (retryAnalyzer=com.sevenrmartsupermarket.listeners.RetryAnalyzer.class)
	public void verifyLogin_Excel()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login_Excel();
		String actualProfileName=homepage.getProfileName();
		System.out.println(actualProfileName);
		String expectedProfileName="admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
		
	}
	
	@Test(groups="Smoke")
	public void verifyData()
	{
		 excelreader.setExcelFile("LoginFile", "Login");
		 System.out.println(excelreader.getCell_Data(1, 0));
		 System.out.println(excelreader.getCell_Data(1, 1));
		 System.out.println(excelreader.getCell_Data(0, 0));
		 System.out.println(excelreader.getCell_Data(0, 1));
		
	}
}
