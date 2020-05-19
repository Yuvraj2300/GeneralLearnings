package com.bms.uki.automate.site;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerMetricsParser {
	public static String getCoverageValueFoorUICV(WebDriver d, long timeout) {
		WebDriverWait wait = new WebDriverWait(d, timeout);
		String	coverageUICV	=	"";
		
		try {
			
/*			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='mstr94']")));
			d.findElement(By.xpath("//div[@id='mstr94']")).click();
			List<WebElement>	dropdownValues	=
					d.findElements(By.xpath("//*[@id='mstr94']/div[1]/div"));	
			
			for(WebElement we:dropdownValues) {
				if(we.getText()=="UI CV")
					break;
				else
					return coverageUICV;
					
			}
*/			
			wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(
							By.xpath(
									"//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']")));
			coverageUICV	=	d.findElement(
								By.xpath(
										"//td[contains(@class,'r-c14_K83')]/ancestor::div[@id='mstr124']")).getText();
		
			
			if(!(coverageUICV.length()>0)) {
				throw new	Exception("Coverage field was either empty or could not be found");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
		System.out.println(coverageUICV);
		return coverageUICV;
	}
}
