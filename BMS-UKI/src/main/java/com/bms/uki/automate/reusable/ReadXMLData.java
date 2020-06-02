package com.bms.uki.automate.reusable;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLData {

	public static WebElement readXmlData(WebDriver driver, String data)
			throws ParserConfigurationException, SAXException, IOException {
		String Loc = null, path = null;
//		File file = XMLReaderSingleton.getInstance("resources/xpathXML/OR.xml");

		DocumentBuilderFactory Df = DocumentBuilderFactory.newInstance();
		DocumentBuilder Db = Df.newDocumentBuilder();
		Document document = Db.parse(ReadXMLData.class.getResourceAsStream("/xpathXML/OR.xml"));

		NodeList list = document.getElementsByTagName("locator");
		Node node1 = list.item(0);

		Element ele = (Element) node1;

		Loc = ele.getElementsByTagName(data).item(0).getAttributes().getNamedItem("path").getNodeValue();
		path = ele.getElementsByTagName(data).item(0).getTextContent();

		return findElement(driver, Loc, path);
		// return ele.getElementsByTagName(data).item(0).getNodeName();
		// return ele.getAttribute("path");
		// return ele.getElementsByTagName(data).item(0).getTextContent();
	}

	public static WebElement findElement(WebDriver driver, String Loc, String path) {
		Logger	logger	=	LoggerFactory.getLogger(ReadXMLData.class);
		
		WebElement findElement = null;
		switch (Loc) {
		case "id":
			findElement = driver.findElement(By.id(path));
			break;
		case "class":
			break;
		case "xpath":
			findElement = driver.findElement(By.xpath(path));
			break;
		case "link":
			// findElement="findElement(By.linkText("+path+"))";
			break;
		case "tagName":
			// findElement="findElement(By.tagName("+path+"))";
			break;
		default:
			System.out.println("no match");
		}

		logger.debug(findElement.getText());
		return findElement;
	}

}
