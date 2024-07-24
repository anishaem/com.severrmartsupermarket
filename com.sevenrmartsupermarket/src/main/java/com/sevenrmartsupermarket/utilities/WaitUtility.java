package com.sevenrmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public WebDriver driver;
	WebDriverWait wait;
	Wait<WebDriver> fluentwait;
	
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void wait_For_Clickable(WebElement element , long duration)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void wait_For_Locator( String locator,long duration)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	/**BY locator**/
	
	public void wait_For_Locator( By locator,long duration)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	public void fluent_wait_For_Clickable(WebElement element ,long timeout_duration, long polling_duration)
	{
		fluentwait =
		        new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(timeout_duration))
		            .pollingEvery(Duration.ofSeconds(polling_duration))
		            .ignoring(ElementNotInteractableException.class);
	}
}
