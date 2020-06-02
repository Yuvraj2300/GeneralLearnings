package com.bms.uki.automate.site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.uki.automate.xlwriter.WriteCustomerTab;

public class CustomerMetricsParser {
	public void setAllMetricsOnPage(WebDriver d, long timeout, HashMap<String, String> filterMap) {
		Logger	logger	=	LoggerFactory.getLogger(CustomerMetricsParser.class);
		
		int counter	=	0;
		
		List<String> mapValues = new ArrayList<String>(filterMap.values());
		mapValues.replaceAll(String::toUpperCase);
		
		Actions action = new Actions(d);
		
		
		try {
			WebDriverWait wait = new WebDriverWait(d, timeout);
			
			for(int i=0;i<5;i++) {
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
						"//*[@class='mstrmojo-ui-Pulldown-text express']/ancestor::div[@class='mstrmojo-ui-Pulldown']")));

				List<WebElement> dropdowns = d.findElements(By.xpath(
						"//*[@class='mstrmojo-ui-Pulldown-text express']/ancestor::div[@class='mstrmojo-ui-Pulldown']"));

				while(counter<5) {
					WebElement dropdown	=	dropdowns.get(counter);
					dropdown.click();

					/*wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
							By.cssSelector("div.mstrmojo-popupList-scrollBar.mstrmojo-scrollNode > div > div.item")));
*/
					List<WebElement> dropdownElements = d.findElements(
							By.cssSelector("div.mstrmojo-popupList-scrollBar.mstrmojo-scrollNode > div > div.item"));

					for (WebElement element : dropdownElements) {
						if (!(element.getText().equals("")) && !(element.getText().isEmpty())) {

							String dropdownText	=	element.getText();
							logger.debug("Current Dropdown value : "+ dropdownText);
						
							if(mapValues.contains(dropdownText.toUpperCase())) {
								
								action.moveToElement(element).click().perform();
								Thread.sleep(9000);
								break;
							}
						}
					}
					counter++;
					break;
				}
			}
			
		
		} catch (Exception e) {
			e.getMessage().toString();
		}
	}

	public String getCoverageValue(WebDriver d, long timeout) {
		Logger logger	=	LoggerFactory.getLogger(WriteCustomerTab.class);
		
		String coverage = "";

		try {
			WebDriverWait wait = new WebDriverWait(d, timeout);
			
			
			logger.info("Getting Coverage Value");
			coverage = d.findElement(By.xpath("//td[contains(@class,'r-c14_K83') and contains(text(),'%') and @ei='0']"))
					.getText();
////td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']
			
			logger.info("Coverage value set : "+coverage);	
		} catch (Exception e) {
			e.getMessage();
		}

		return coverage;
	}
}
