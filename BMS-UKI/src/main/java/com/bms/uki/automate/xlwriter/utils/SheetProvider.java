package com.bms.uki.automate.xlwriter.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.bms.uki.automate.model.ExcelReaderSingleton;

public class SheetProvider {

	public SheetProvider() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
	}

	public Sheet getSheetFromWorkbook(String path, String sheetName) throws FileNotFoundException {
		File configFile = ExcelReaderSingleton.getInstance(path);
		FileInputStream inpStream = new FileInputStream(configFile);
		Sheet sheet = null;

		try {
			Workbook wb = WorkbookFactory_Custom.createWorkBook(inpStream);
			sheet = SheetFactory.getSheet(wb, sheetName);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return sheet;
	}
}
