package com.bms.uki.automate.legacy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login  {

	
	public static WebDriver driver;
	
	@BeforeTest
	public void InitializeDriver()
	{
	   System.setProperty("webdriver.chrome.driver","C:\\Learning 2020\\ALM\\chromedriver1\\chromedriver.exe");	
    // ChromeDriver driver;
	    driver=new ChromeDriver();
		driver.manage().window().maximize();	
		
	}
	
	@Test
	public void LoginFunctionality() throws Exception
	{   
	
	//	System.out.println(PropertiesReader.getValue("url"));

		driver.get(ExcelReader.getValue("url"));
		Thread.sleep(2000);
		driver.findElement(By.id("bms-id")).sendKeys(ExcelReader.getValue("username"));
		driver.findElement(By.id("bms-pass")).sendKeys(ExcelReader.getValue("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
}
