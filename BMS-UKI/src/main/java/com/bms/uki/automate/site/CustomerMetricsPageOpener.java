package com.bms.uki.automate.site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.uki.automate.reusable.ReadXMLData;

public class CustomerMetricsPageOpener {
	
	
	public static void customerMetricsPage(WebDriver d,long timeout) {		WebDriverWait	wait	=	new WebDriverWait(d, timeout);
		
		Logger	logger	=	LoggerFactory.getLogger(CustomerMetricsPageOpener.class);
	
		Actions action = new Actions(d);
		
		try {
		
		Thread.sleep(5000);
		
		/*wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath(
							"//a[contains(text(),'UKI - CSCOR')]/ancestor::div[@class='mstrProjectItem']")));*/
		
		logger.info("Opening UKI-CSOR now");
		
		action.moveToElement(
				ReadXMLData
					.readXmlData(d, "ukicsor"))
						.click()
							.perform();
		
		Thread.sleep(3000);
		
		/*wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath(
						"//a[contains(text(),'UK Home')]/ancestor::div[@class='mstrLargeIconItemContainer']")));
		*/
		logger.info("Opening UK-Home");
		
		action.moveToElement(
				ReadXMLData
					.readXmlData(d, "ukhome"))
						.click()
							.perform();
		
		Thread.sleep(4000);
		
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath(
								"//div[contains(text(),'Customer List')]")));

		logger.info("Opening Customer List Dashboard");
		
		action.moveToElement(
					ReadXMLData
						.readXmlData(d, "customerlist"))
										.click()
											.perform();

		}catch(Exception	e) {
		System.out.println(e.getMessage().toString());
	}
	}
}
