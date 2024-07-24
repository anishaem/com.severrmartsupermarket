package com.sevenrmartsupermarket.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;

	/** to read properties file **/
	Properties properties = new Properties();
	ScreenshotCapture screenshot = new ScreenshotCapture();

	public Base() {
		try {

			FileInputStream fileInputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileInputStream);
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	/** intialise browser **/
	public void initialiseBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	@BeforeMethod(enabled = true,alwaysRun=true)
	public void launchBrowser() {
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		initialiseBrowser(browser, url);
	}

	/**
	 * crossbrowser usage --> check xml file also
	 * 
	 * @Parameters tag is to fetch data
	 **/
	@Parameters("browser")
	@BeforeMethod(enabled = false,alwaysRun=true)
	public void launchBrowser(String browser) {

		String url = properties.getProperty("url");
		initialiseBrowser(browser, url);
	}

	@AfterMethod(alwaysRun=true)
	public void terminateSession(ITestResult itestResult) {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			screenshot.takeScreeshot(driver, itestResult.getName());
		}
	}

}
