package com.bms.uki.automate.site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerMetricsPageOpener {
	public static void customerMetricsPage(WebDriver d,long timeout) {
		WebDriverWait	wait	=	new WebDriverWait(d, timeout);
		

		
		try {
		
		Thread.sleep(5000);
		
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath(
							"//a[contains(text(),'UKI - CSCOR')]/ancestor::div[@class='mstrProjectItem']")));
		d.findElement(By.xpath(
				"//a[contains(text(),'UKI - CSCOR')]/ancestor::div[@class='mstrProjectItem']")).click();
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.xpath(
						"//a[contains(text(),'UK Home')]/ancestor::div[@class='mstrLargeIconItemContainer']")));
		d.findElement(
				By.xpath(
						"//a[contains(text(),'UK Home')]/ancestor::div[@class='mstrLargeIconItemContainer']")).click();
		
		Thread.sleep(5000);
		
		wait.until(
				ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath(
								"//div[@id = 'mstr115']/ancestor::div[@class='mstrmojo-DocTextfield  hasLink']")));
		d.findElement(
				By.xpath(
						"//div[@id = 'mstr115']/ancestor::div[@class='mstrmojo-DocTextfield  hasLink']")).click();
		
		}catch(Exception	e) {
			System.out.println(e.getMessage().toString());
		}
	}
}
