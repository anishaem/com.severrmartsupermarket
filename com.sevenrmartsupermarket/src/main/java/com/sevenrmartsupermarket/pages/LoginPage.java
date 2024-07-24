package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginPage {

	public WebDriver driver;
	/** to read properties file **/
	Properties properties =new Properties();
	ExcelReader excelreader = new ExcelReader();

	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		

		try {
			
			FileInputStream fileInputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileInputStream);
		}
		
		catch (Exception e){
			
			e.printStackTrace();
		}
	}

	
	public void enterUserName(String userName)

	{
		userNameField.sendKeys(userName);
	}

	public void enterpassword(String password)

	{
		passwordField.sendKeys(password);
	}

	public void clickOnSignIn() {
		signInButton.click();
	}
	
	public void login(String userName, String password)
	{
		enterUserName(userName);
		enterpassword(password);
		clickOnSignIn();
	}
	
	public HomePage login()
	{
		String userName =properties.getProperty("userName");
		String password=properties.getProperty("password");
		enterUserName(userName);
		enterpassword(password);
		clickOnSignIn();
		return new HomePage(driver);
	}
	
	public void login_Excel()
	{
		 excelreader.setExcelFile("LoginFile", "Login");
		 String userName= excelreader.getCell_Data(1, 0);
		 String password=excelreader.getCell_Data(1, 1);
		enterUserName(userName);
		enterpassword(password);
		clickOnSignIn();
	}
	

}
