package com.bms.uki.automate.reusable;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login   {

		
	/*@BeforeTest
	public void InitializeDriver() throws Exception
	{
	    System.setProperty("webdriver.chrome.driver","C:\\Learning 2020\\ALM\\chromedriver1\\chromedriver.exe");	
	    driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get(ExcelReader.getValue("url"));
		Thread.sleep(2000);
	}
	*/
//	@Test
	
	public void LoginFunctionality(WebDriver	d) throws Exception
	{   
		
	  ReadXMLData.readXmlData(d,"username").sendKeys(ExcelReader.getValue("username"));
	  ReadXMLData.readXmlData(d,"password").sendKeys(ExcelReader.getValue("password"));
	  ReadXMLData.readXmlData(d,"submit").click();
	
	}
  
	
	

}
