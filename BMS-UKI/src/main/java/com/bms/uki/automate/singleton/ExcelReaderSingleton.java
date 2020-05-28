package com.bms.uki.automate.singleton;

import java.io.File;

public class ExcelReaderSingleton extends File {

	private static ExcelReaderSingleton excelReader = null;

	File file;

	private ExcelReaderSingleton(String path) {
		super(path);
		file = new File(path);
	}

	public static ExcelReaderSingleton getInstance(String path) {
		if (excelReader == null) {
			excelReader = new ExcelReaderSingleton(path);
		}
		return excelReader;
	}
}
