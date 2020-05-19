package com.bms.uki.automate.legacy;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLData {
	
	
	public static String readXmlData(String data) throws ParserConfigurationException, SAXException, IOException {
		File file = new File("C:\\Framework\\OR.xml");
		DocumentBuilderFactory Df = DocumentBuilderFactory.newInstance();
		DocumentBuilder Db = Df.newDocumentBuilder();
		Document document = Db.parse(file);
		NodeList list = document.getElementsByTagName("locator");
		Node node1 = list.item(0);
		Element ele = (Element) node1;
		
		return ele.getElementsByTagName(data).item(0).getAttributes().getNamedItem("path").getNodeValue();
		//return ele.getElementsByTagName(data).item(0).getNodeName();
		//return ele.getAttribute("path");
		//return ele.getElementsByTagName(data).item(0).getTextContent();
	}
	
	public static String findElement(String Loc,String path)
	{ 
	   String findElement=null;
		switch(Loc) 
        { 
            case "id": 
                findElement="findElement(By.id(path))";
                break; 
            case "class": 
            	findElement="findElement(By.className(path))";
                break; 
            case "xpath": 
            	findElement="findElement(By.xpath(path))";
                break; 
            case "link": 
            	findElement="findElement(By.linkText(path))";
                break;        
            case "tagName": 
            	findElement="findElement(By.tagName(path))";
                break; 
            default: 
                System.out.println("no match"); 
        }  
		
		return findElement;
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

	 
	System.out.println(readXmlData("gmail"));
}
	
}
