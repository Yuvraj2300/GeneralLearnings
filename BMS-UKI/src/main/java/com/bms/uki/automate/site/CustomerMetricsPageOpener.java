package com.bms.uki.automate.site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bms.uki.automate.legacy.ReadXMLData;

public class CustomerMetricsPageOpener {
	public static void customerMetricsPage(WebDriver d,long timeout) {		WebDriverWait	wait	=	new WebDriverWait(d, timeout);
		
		
		Actions action = new Actions(d);
		
		try {
		
		Thread.sleep(5000);
		
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath(
							"//a[contains(text(),'UKI - CSCOR')]/ancestor::div[@class='mstrProjectItem']")));
		
		action.moveToElement(
				ReadXMLData
					.readXmlData(d, "ukicsor"))
						.click()
							.perform();
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath(
						"//a[contains(text(),'UK Home')]/ancestor::div[@class='mstrLargeIconItemContainer']")));
		
		action.moveToElement(
				ReadXMLData
					.readXmlData(d, "ukhome"))
						.click()
							.perform();
		
		Thread.sleep(5000);
		
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath(
								"//div[contains(text(),'Customer List')]")));

		
		action.moveToElement(
					ReadXMLData
						.readXmlData(d, "customerlist"))
										.click()
											.perform();


			/*
			 * try { ReadXMLData.readXmlData(d, "customerlist").click();} catch(Exception e)
			 * { ReadXMLData.readXmlData(d, "customerlistfallback").click(); }
			 */
		}catch(Exception	e) {
		System.out.println(e.getMessage().toString());
	}
	}
}
