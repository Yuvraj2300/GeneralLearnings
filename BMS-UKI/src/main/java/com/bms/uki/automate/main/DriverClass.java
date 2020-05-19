package com.bms.uki.automate.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bms.uki.automate.model.LoginPageModel;
import com.bms.uki.automate.site.CustomerMetricsPageOpener;
import com.bms.uki.automate.site.SiteLogin;

public class DriverClass {
	public static void main(String[] args) {

		long timeout = 20;
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver_81.exe");
		
		try {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://bmseu.mstr.zsservices.com/MSTRBMSEUWEB/html/BMSEU.html");
	
			LoginPageModel loginModel = new LoginPageModel("naseers", "sn2020sn");
			SiteLogin.login(loginModel, driver);
			
			CustomerMetricsPageOpener.customerMetricsPage(driver, timeout);
		}catch(Exception	e) {
			System.out.println(e.getMessage().toString());
		}
	}
}