package com.bms.uki.automate.legacy;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static final String Excel = "resources/UKI_QC_Config.xlsm";

	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;

	public static void loadExcel() throws Exception {
		System.out.println("Loading Excel...");

		File file = new File(Excel);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Login");
		fis.close();

	}

	public static Map<String, Map<String, String>> getDataMap() throws Exception {

		if (sheet == null) {
			loadExcel();
		}

		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		Map<String, String> myMap = new HashMap<String, String>();

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			String keyCell = row.getCell(0).getStringCellValue();

			int colNum = row.getLastCellNum();
			// System.out.println(colNum);
			for (int j = 1; j < colNum; j++) {
				String value = row.getCell(j).getStringCellValue();
				myMap.put(keyCell, value);
			}
			superMap.put("MASTERDATA", myMap);
		}
		return superMap;
	}

	public static Map<String, Map<String, String>> getDataMapFilter() throws Exception {

		if (sheet == null) {
			loadExcel();
		}

		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		Map<String, String> myMap = new HashMap<String, String>();

		row = sheet.getRow(0);

		for (int i = 0; i < row.getLastCellNum(); i++) {
			String keyCell = row.getCell(i).getStringCellValue();

			for (int j = sheet.getLastRowNum(); j > 0; j--)

			{
				String value = sheet.getRow(j).getCell(i).getStringCellValue();
				myMap.put(keyCell, value);
			}

			superMap.put("MASTERDATA", myMap);
		}

		return superMap;
	}

	public static String getValue(String key) throws Exception {
		Map<String, String> myVal = getDataMap().get("MASTERDATA");
		String retValue = myVal.get(key);
		return retValue;
	}

}
