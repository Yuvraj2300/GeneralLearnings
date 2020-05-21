package com.bms.uki.automate.legacy;



import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLData {
	
	
	public static WebElement readXmlData(WebDriver driver,String data) throws ParserConfigurationException, SAXException, IOException {
		String Loc=null, path=null;
		File file = new File("resources/OR.xml");
		
		DocumentBuilderFactory Df = DocumentBuilderFactory.newInstance();
		DocumentBuilder Db = Df.newDocumentBuilder();
		Document document = Db.parse(file);
		
		NodeList list = document.getElementsByTagName("locator");
		Node node1 = list.item(0);
		
		Element ele = (Element) node1;
		
		Loc= ele.getElementsByTagName(data).item(0).getAttributes().getNamedItem("path").getNodeValue();
		path=ele.getElementsByTagName(data).item(0).getTextContent();
		
		return findElement(driver,Loc,path);
		//return ele.getElementsByTagName(data).item(0).getNodeName();
		//return ele.getAttribute("path");
		//return ele.getElementsByTagName(data).item(0).getTextContent();
	}
	
	public static WebElement findElement(WebDriver driver,String Loc,String path)
	{ 
	   WebElement findElement=null;
//	   System.out.println(Loc);
//	   System.out.println(path);
//	   System.out.println(path.compareTo("//*[@id='bms-id']"));
//	   System.out.println(driver.getCurrentUrl());
		switch(Loc) 
        { 
            case "id": 
            	findElement=driver.findElement(By.id(path));
                break; 
            case "class": 
            //	findElement="findElement(By.className("+path+"))";
                break; 
            case "xpath": 
            	findElement=driver.findElement(By.xpath(path));
            	//findElement="findElement(By.xpath("+path+"))";
                break; 
            case "link": 
            	//findElement="findElement(By.linkText("+path+"))";
                break;        
            case "tagName": 
            	//findElement="findElement(By.tagName("+path+"))";
                break; 
            default: 
                System.out.println("no match"); 
        }  
		
		System.out.println(findElement.getText());
		return findElement;
	}
	
}
