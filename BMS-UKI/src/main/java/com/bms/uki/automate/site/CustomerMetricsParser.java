package com.bms.uki.automate.site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerMetricsParser {
	public static String getCoverageValueFoorUICV(WebDriver d, long timeout) {
		WebDriverWait wait = new WebDriverWait(d, timeout);
		String coverageUICV = "";

		try {
			Thread.sleep(5000);

			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mstr94']")));
			d.findElement(By.xpath("//div[@id='mstr94']")).click();

			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/div[1]")));

			WebElement dropdownValue = d.findElement(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/div[1]"));

			/*
			 * List<WebElement> dropdownOptions = dropdownValues.findElements( By.xpath(
			 * "*"));
			 * 
			 * 
			 * for(WebElement we:dropdownOptions) { if(we.getText()=="UI CV") break; else
			 * return coverageUICV;
			 * 
			 * }
			 */

			if (!((dropdownValue.getText()) != "UI CV")) {
				return coverageUICV = "";
			} else {

				dropdownValue.click();

				Thread.sleep(10000);

				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']")));
				coverageUICV = d
						.findElement(By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']"))
						.getText();

				if (!(coverageUICV.length() > 0)) {
					throw new Exception("Coverage field was either empty or could not be found");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		System.out.println(coverageUICV);
		return coverageUICV;
	}

	public static String getCoverageValueFoorUIIMM(WebDriver d, long timeout) {
		WebDriverWait wait = new WebDriverWait(d, timeout);
		String coverageUIIMM = "";

		try {
			//
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mstr94']")));
			d.findElement(By.xpath("//div[@id='mstr94']")).click();

			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/div[2]")));

			WebElement dropdownValue = d.findElement(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/div[2]"));

			/*
			 * List<WebElement> dropdownOptions = dropdownValues.findElements( By.xpath(
			 * "*"));
			 * 
			 * 
			 * for(WebElement we:dropdownOptions) { if(we.getText()=="UI CV") break; else
			 * return coverageUICV;
			 * 
			 * }
			 */

			if (!((dropdownValue.getText()) != "UI IIM")) {
				return coverageUIIMM = "";
			} else {

				dropdownValue.click();

				Thread.sleep(10000);

				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']")));
				coverageUIIMM = d
						.findElement(By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']"))
						.getText();

				if (!(coverageUIIMM.length() > 0)) {
					throw new Exception("Coverage field was either empty or could not be found");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		System.out.println(coverageUIIMM);
		return coverageUIIMM;
	}

	public static String getCoverageValueFoorUIONC(WebDriver d, long timeout) {
		WebDriverWait wait = new WebDriverWait(d, timeout);
		String coverageUIONC = "";

		try {
			//
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mstr94']")));
			d.findElement(By.xpath("//div[@id='mstr94']")).click();

			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/div[3]")));

			WebElement dropdownValue = d.findElement(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/div[3]"));

			/*
			 * List<WebElement> dropdownOptions = dropdownValues.findElements( By.xpath(
			 * "*"));
			 * 
			 * 
			 * for(WebElement we:dropdownOptions) { if(we.getText()=="UI CV") break; else
			 * return coverageUICV;
			 * 
			 * }
			 */

			if (!((dropdownValue.getText()) != "UI ONC")) {
				return coverageUIONC = "";
			} else {

				dropdownValue.click();

				Thread.sleep(10000);

				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']")));
				coverageUIONC = d
						.findElement(By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']"))
						.getText();

				if (!(coverageUIONC.length() > 0)) {
					throw new Exception("Coverage field was either empty or could not be found");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		System.out.println(coverageUIONC);
		return coverageUIONC;
	}

	public HashMap<String, String> getCoverageMetric(WebDriver d, long timeout) {
		WebDriverWait wait = new WebDriverWait(d, timeout);
		HashMap<String, String> metricsvals = new HashMap<>();

		metricsvals.put("UI CV", "");
		metricsvals.put("UI IIM", "");
		metricsvals.put("UI ONC", "");

		try {
			//
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mstr94']")));
			d.findElement(By.xpath("//div[@id='mstr94']")).click();

			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/")));

			WebElement dropdownValues = d.findElement(By.xpath(
					"//div[@class='mstrmojo-PopupList ctrl-popup-list mstrmojo-scrollbar-host hasVertical']/div[1]/div/"));

			List<WebElement> dropdownOptions = dropdownValues.findElements(By.xpath("*"));

			for (WebElement we : dropdownOptions) {
				if (!(we.getText() == "UI CV"))
					System.out.println("");
				else {
					we.click();
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
							By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']")));
					if (metricsvals.containsKey(we.getText())) {
						metricsvals.put(we.getText(),
								d.findElement(
										By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']"))
										.getText());
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		return metricsvals;
	}

	public String checkMetricsMap(HashMap<String, String> metricsMap) {

		return "";
	}

	//------------------------------------------------------------------------------------------------------
	
	
	
	public void setAllMetricsOnPage(WebDriver d, long timeout, HashMap<String, String> filterMap) {

		List<String> mapValues = new ArrayList<String>(filterMap.values());
		Actions action = new Actions(d);
		
		
		try {
			WebDriverWait wait = new WebDriverWait(d, timeout);
			
			
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
					"//*[@class='mstrmojo-ui-Pulldown-text express']/ancestor::div[@class='mstrmojo-ui-Pulldown']")));

			List<WebElement> dropdowns = d.findElements(By.xpath(
					"//*[@class='mstrmojo-ui-Pulldown-text express']/ancestor::div[@class='mstrmojo-ui-Pulldown']"));

			for (WebElement dropdown : dropdowns) {
				dropdown.click();

				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
						By.cssSelector("div.mstrmojo-popupList-scrollBar.mstrmojo-scrollNode > div > div.item")));

				List<WebElement> dropdownElements = d.findElements(
						By.cssSelector("div.mstrmojo-popupList-scrollBar.mstrmojo-scrollNode > div > div.item"));

				for (WebElement element : dropdownElements) {
					
					
					if (!(element.getText().equals("")) && !(element.getText().isEmpty())) {

						String dropdownText	=	element.getText();
						System.out.println("drpdown txt: "+dropdownText);
						
						if(mapValues.contains(dropdownText)) {
							
							action.moveToElement(element).click().perform();
							Thread.sleep(10000);
							dropdown.click();
						}
					}
				}
			}
		} catch (Exception e) {
			e.getMessage().toString();
		}
	}

	public String getCoverageValue(WebDriver d, long timeout) {
		String coverage = "";

		try {
			WebDriverWait wait = new WebDriverWait(d, timeout);

			coverage = d.findElement(By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']"))
					.getText();

		} catch (Exception e) {
			e.getMessage();
		}

		return coverage;
	}

	/*
	 * coverageValue = d .findElement(
	 * By.xpath("//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']"))
	 * .getText();
	 */
}
