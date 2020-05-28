package com.bms.uki.automate.singleton;

import java.io.File;

public class XMLReaderSingleton extends File {

	private static XMLReaderSingleton xmlReaderSingleton = null;

	File file;

	private XMLReaderSingleton(String path) {
		super(path);
		file = new File("resources/OR.xml");
	}

	public static XMLReaderSingleton getInstance(String path) {
		if (xmlReaderSingleton == null) {
			xmlReaderSingleton = new XMLReaderSingleton(path);
		}

		return xmlReaderSingleton;
	}
}
