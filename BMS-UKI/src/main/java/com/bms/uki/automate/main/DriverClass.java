package com.bms.uki.automate.main;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.model.LoginPageModel;
import com.bms.uki.automate.site.CustomerMetricsPageOpener;
import com.bms.uki.automate.site.SiteLogin;
import com.bms.uki.automate.xlwriter.WriteCustomerTab;

public class DriverClass {
	
	public static void main(String[] args) {
		Logger	logger	=	LoggerFactory.getLogger(DriverClass.class);
		
		try {
			

			Properties prop = new Properties();
			logger.info("Loading Properties File");
			System.out.println("Loading Properties File");
			prop.load(DriverClass.class.getResourceAsStream("/config/config.properties"));
			logger.info("Properties File loaded");
			
			
			long timeout = 55;
			logger.info("Setting property for ChromeDriver");
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver"));
			System.setProperty("org.slf4j.simpleLogger.logFile", "System.out");
			logger.info("Property for ChromeDriver loaded");
			CustomerListMetricsModel metricsModel = new CustomerListMetricsModel();

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			logger.info("Navigating to the mstr dashboard");
			driver.navigate().to("https://bmseu.mstr.zsservices.com/MSTRBMSEUWEB/html/BMSEU.html");
			
			
			
			logger.info("Logging In");
			SiteLogin.login(driver);

			
			CustomerMetricsPageOpener.customerMetricsPage(driver, timeout);

			Thread.sleep(20000);

			WriteCustomerTab.writeCustomerTab(driver, metricsModel);

			logger.info("Quitting now, Bye!");
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
