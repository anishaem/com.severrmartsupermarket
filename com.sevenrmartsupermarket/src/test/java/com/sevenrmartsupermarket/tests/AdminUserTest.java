package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {

	AdminUserPage adminUser;
	LoginPage loginpage;
	HomePage homepage;

	@Test(groups = "Smoke")
	public void verify_AdminUserLanding() {
		loginpage = new LoginPage(driver);
        homepage=loginpage.login();
	    
		homepage.clickOn_AdminUser();
		String actualProfile = adminUser.getProfileName();
		String expectedProfile = "Admin Users";
		Assert.assertEquals(actualProfile, expectedProfile);
	}

	@Test(groups = { "Smoke", "Regression" })
	public void verify_NewAdmin_CreatePageLanding() {
		loginpage = new LoginPage(driver);

		loginpage.login();
		adminUser = new AdminUserPage(driver);
		adminUser=homepage.clickOn_AdminUser();
		adminUser.clickOn_NewUser();
		String actualAdminProfile = adminUser.getAdminProfileName();
		String expectedAdminProfile = "Admin Users Informations";
		Assert.assertEquals(actualAdminProfile, expectedAdminProfile);

	}

	// groups= {"Smoke","Regression"},
	/**
	 * dataProvider="UserCreationData",dataProviderClass=DataProviders.class also
	 * pass parameters in method String username,String password
	 **/
	@Test(groups = { "Smoke", "Regression" })
	public void verify_Create_NewAdminUser() {
		loginpage = new LoginPage(driver);

		loginpage.login();
		adminUser = new AdminUserPage(driver);
		adminUser=homepage.clickOn_AdminUser();
		adminUser.clickOn_NewUser();
		String username = GeneralUtility.getRandomName();
		String password = "admin@123";
		adminUser.createUser(username, password, "Admin");
		adminUser.clickOnUserCreate();

	}

	@Test(groups = { "Smoke",
			"Regression" }, dataProvider = "UserCreationDataFromExcel", dataProviderClass = DataProviders.class)
	public void verify_Create_NewAdminUser2(String username, String password,String userType) {
		loginpage = new LoginPage(driver);

		loginpage.login();
		adminUser = new AdminUserPage(driver);
		adminUser=homepage.clickOn_AdminUser();
		adminUser.clickOn_NewUser();
		adminUser.createUser(username, password, userType);
		adminUser.clickOnUserCreate();

	}

}
