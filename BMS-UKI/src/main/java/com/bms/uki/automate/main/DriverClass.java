package com.bms.uki.automate.main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.model.LoginPageModel;
import com.bms.uki.automate.site.CustomerMetricsPageOpener;
import com.bms.uki.automate.site.CustomerMetricsParser;
import com.bms.uki.automate.site.SiteLogin;
import com.bms.uki.automate.xlwriter.WriteCustomerTab;

public class DriverClass {
	public static void main(String[] args) {

		long timeout = 55;
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver_81.exe");
		WriteCustomerTab	custWrite	=	new	WriteCustomerTab();
		CustomerListMetricsModel	metricsModel	=	new	CustomerListMetricsModel();
		
		try {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://bmseu.mstr.zsservices.com/MSTRBMSEUWEB/html/BMSEU.html");
	
			SiteLogin.login(driver);		
			
			CustomerMetricsPageOpener.customerMetricsPage(driver, timeout);
			
			Thread.sleep(20000);
			
			metricsModel.setCoverageUICV(CustomerMetricsParser.getCoverageValueFoorUICV(driver, timeout));
			metricsModel.setCoverageUIIMM(CustomerMetricsParser.getCoverageValueFoorUIIMM(driver, timeout));
			metricsModel.setCoverageUIIMM(CustomerMetricsParser.getCoverageValueFoorUIONC(driver, timeout));
			
			
			custWrite.writeCustomerTab(metricsModel);
			
		}catch(Exception	e) {
			System.out.println(e.getMessage().toString());
		}
	}
}
