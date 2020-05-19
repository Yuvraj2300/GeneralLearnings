package com.bms.uki.automate.xlwriter.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WorkbookFactory_Custom {
	public	static Workbook createWorkBook(FileInputStream inpStream)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		return WorkbookFactory.create(inpStream);
	}
}
