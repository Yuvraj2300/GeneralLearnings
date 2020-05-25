package com.bms.uki.automate.model;

import java.io.File;
import java.io.FileNotFoundException;

public class ExcelWriterSingleton extends File {

	private static ExcelWriterSingleton excelWriter;

	File file;

	private ExcelWriterSingleton(String path) throws FileNotFoundException {
		super(path);
		file = new File(path);
	}

	public static ExcelWriterSingleton getInstance(String path) throws FileNotFoundException {
		if (excelWriter == null) {
			excelWriter = new ExcelWriterSingleton(path);
		}
		return excelWriter;
	}
}
