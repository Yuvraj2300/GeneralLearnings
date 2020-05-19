package com.bms.uki.automate.site;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.bms.uki.automate.model.LoginPageModel;

public class SiteLogin {
	public static void login(LoginPageModel model, WebDriver d) {
		String	username	=	model.getUsername();
		String	password	=	model.getPassword();
		
		try {
		d.findElement(By.id("bms-id")).sendKeys(username);;
		d.findElement(By.id("bms-pass")).sendKeys(password);;
		
		d.findElement(By.xpath("//button[@type='submit']")).click();
		}catch (Exception e) {
			System.out.println(e.getMessage().toString());
			e.printStackTrace();
		}
	}
}
