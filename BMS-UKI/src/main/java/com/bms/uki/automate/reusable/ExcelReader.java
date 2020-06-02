package com.bms.uki.automate.reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.uki.automate.main.DriverClass;
import com.bms.uki.automate.model.LoginPageModel;

public class ExcelReader {

//	public static final String Excel = "resources/UKI_QC_Config.xlsm";

	private static InputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;

	public static void loadExcel() throws Exception {
		Logger logger	=	LoggerFactory.getLogger(ExcelReader.class);
//		FileInputStream configFis = new FileInputStream("resources/config/config.properties");

		Properties prop = new Properties();
		prop.load(DriverClass.class.getResourceAsStream("/config/config.properties"));

		logger.info("Loading config Excel to read login details");

		File file = new File(prop.getProperty("configFile"));
		
		fis = new FileInputStream(file);
		
		workbook = new XSSFWorkbook(fis);
		
		sheet = workbook.getSheet("Login Config");
		
		fis.close();

	}

	public static Map<String, Map<String, String>> getDataMap() throws Exception {

		if (sheet == null) {
			loadExcel();
		}

		LoginPageModel loginPageModel = new LoginPageModel();

		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		Map<String, String> myMap = new HashMap<String, String>();

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);

			if (row.getCell(1) != null && !(row.getCell(1).getStringCellValue().equals(""))
					&& !(row.getCell(1).getStringCellValue().equals("Login Configuration"))) {
				String keyValue = row.getCell(1).getStringCellValue().replace(":", "").toUpperCase();
				String value = row.getCell(2).getStringCellValue();
				
				if (keyValue.equalsIgnoreCase("report link")) {
					loginPageModel.setReportLink(row.getCell(2).getStringCellValue());
				} else if (keyValue.equalsIgnoreCase("username")) {
					loginPageModel.setUsername(row.getCell(2).getStringCellValue());
				} else if (keyValue.equalsIgnoreCase("results location")) {
					loginPageModel.setResultsLocation(row.getCell(2).getStringCellValue());
				}
				
				myMap.put(keyValue, value);
			}
		}
		superMap.put("MASTERDATA", myMap);
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
		String retValue = "";
		Map<String, String> myVal = getDataMap().get("MASTERDATA");
		String keyUpper = key.toUpperCase();

		if (myVal.containsKey(keyUpper)) {
			retValue = myVal.get(keyUpper);
		}

		return retValue;
	}

}
