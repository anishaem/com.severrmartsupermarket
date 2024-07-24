package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileNameElement;
	@FindBy(xpath="//div[@class='col-lg-3 col-6']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUserTileInfo;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName()

	{
		return profileNameElement.getText();
	}
	
	
	public AdminUserPage clickOn_AdminUser()
	{
		adminUserTileInfo.click();
		return  new AdminUserPage(driver);
	}
}
