package com.bms.uki.automate.main;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.model.LoginPageModel;
import com.bms.uki.automate.site.CustomerMetricsPageOpener;
import com.bms.uki.automate.site.SiteLogin;
import com.bms.uki.automate.xlwriter.WriteCustomerTab;

public class DriverClass {
	public static void main(String[] args) {
		try {
			

			Properties prop = new Properties();
			prop.load(DriverClass.class.getResourceAsStream("/config/config.properties"));

			long timeout = 55;
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			CustomerListMetricsModel metricsModel = new CustomerListMetricsModel();

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://bmseu.mstr.zsservices.com/MSTRBMSEUWEB/html/BMSEU.html");
			
			
			
			
			SiteLogin.login(driver);

			CustomerMetricsPageOpener.customerMetricsPage(driver, timeout);

			Thread.sleep(20000);

			WriteCustomerTab.writeCustomerTab(driver, metricsModel);

			driver.quit();
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}

	public void readPropertiesFile() {
		try {
			FileInputStream configFis = new FileInputStream("config/config.properties");
			Properties prop = new Properties();
			prop.load(configFis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
