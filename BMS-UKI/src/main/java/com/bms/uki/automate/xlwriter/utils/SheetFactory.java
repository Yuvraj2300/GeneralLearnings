package com.bms.uki.automate.xlwriter.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class SheetFactory {
	public	static Sheet getSheet(Workbook wb, String name) {
		return wb.getSheet(name);
	}
}
