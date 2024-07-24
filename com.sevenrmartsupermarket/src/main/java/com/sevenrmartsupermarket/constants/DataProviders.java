package com.sevenrmartsupermarket.constants;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class DataProviders {

	ExcelReader excelreader = new ExcelReader();
	
	@DataProvider(name = "UserCreationData")
	public Object[][] adminUserData() {
		return new Object[][] { { "test124", "admin","Admin" },{ "test125", "admin","Staff" } };
	}
	
	@DataProvider(name = "UserCreationDataFromExcel")
	public Object[][] adminUserDataFromExcel() {
		//WB and sheet name
		excelreader.setExcelFile("UserData", "UserData");
		//pass rowcount and columncount
		return excelreader.getMultidimentionalData(2, 3);
	}
}
