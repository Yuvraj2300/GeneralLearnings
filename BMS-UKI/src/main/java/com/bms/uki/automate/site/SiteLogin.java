package com.bms.uki.automate.site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bms.uki.automate.legacy.ExcelReader;
import com.bms.uki.automate.legacy.ReadXMLData;
import com.bms.uki.automate.model.LoginPageModel;

public class SiteLogin {
	public static void login(WebDriver d) {

		try {
			ReadXMLData.readXmlData(d, "username").sendKeys(ExcelReader.getValue("username"));
			ReadXMLData.readXmlData(d, "password").sendKeys(ExcelReader.getValue("password"));
			ReadXMLData.readXmlData(d, "submit").click();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
}
