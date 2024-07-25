package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUserPage {

	public WebDriver driver;

	@FindBy(xpath = "//div[@class='small-box bg-info']//p[contains(text(),'Admin')]")
	WebElement adminUserTile;
	@FindBy(xpath = "//div[@class='col-sm-6']//h1[contains(text(),'Admin Users')]")
	WebElement adminProfileElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement admin_NewButton;
	@FindBy(xpath = "//h3[@class='card-title']")
	WebElement admin_NewPageTextField;
	@FindBy(xpath = "//input[@id='username']")
	WebElement createUserNameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement createPasswordField;
	@FindBy(xpath = "//Select[@id='user_type']")
	WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement userCreateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement userCreateAlert;

	PageUtility pageutility;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getHeader()

	{
		return adminProfileElement.getText();
	}

	public void clickOn_NewUser() {
		admin_NewButton.click();
		;
	}

	public String getAdminProfileName()

	{
		return admin_NewPageTextField.getText();
	}

	/**
	 * public String NewUserName()
	 * 
	 * { return GeneralUtility.getRandomName() + "Admin" ;
	 * 
	 * }
	 **/

	/**
	 * public String NewPassword()
	 * 
	 * { return NewUserName() + "@123"; }
	 **/

	public void enterUserName(String userName)

	{
		createUserNameField.sendKeys(userName);
	}

	public void enterPassword(String password)

	{
		createPasswordField.sendKeys(password);
	}

	/**
	 * public void enterNewUserName()
	 * 
	 * { createUserNameField.sendKeys(NewUserName()); } public void
	 * enterNewPassword()
	 * 
	 * { createPasswordField.sendKeys(NewPassword()); }
	 **/

	public void selectUserType(String userType) {
		pageutility = new PageUtility(driver);
		pageutility.select_ByVisibleText(userTypeDropDown, userType);
	}

	public void clickOnUserCreate() {
		userCreateButton.click();
	}

	public String getAlertTextOnUserCreation() {
		return userCreateAlert.getText();
	}

	public void createUser(String userName, String password, String userType) {
		enterUserName(userName);
		enterPassword(password);
		selectUserType(userType);
	}
	/**
	 * public void AddAdminUser() { pageutility= new PageUtility(driver);
	 * enterNewserName(); enterNewPassword();
	 * pageutility.select_ByVisibleText(userTypeDropDown, "Admin");
	 * clickOnUserCreate();
	 * 
	 * }
	 **/
}
