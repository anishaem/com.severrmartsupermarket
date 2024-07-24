package com.sevenrmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> dataList = new ArrayList<String>();

		for (WebElement element : elements) {

			dataList.add(element.getText());
		}
		return dataList;
	}

	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String get_cssValue(WebElement element, String cssValue) {
		return element.getCssValue(cssValue);
	}
	
	
	public static  String getRandomName()
	{
		Faker faker = new Faker();
		return faker.name().firstName();
	}

}
