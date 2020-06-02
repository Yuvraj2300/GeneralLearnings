package com.bms.uki.automate.xlwriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.uki.automate.main.DriverClass;
import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.model.LoginPageModel;
import com.bms.uki.automate.xlwriter.utils.SheetProvider;
import com.bms.uki.automate.xlwriter.utils.WorkbookFactory_Custom;

public class WriteCustomerTab {

	public static String getOutputPath() {

		LoginPageModel loginModel = new LoginPageModel();

		try {
			String ouputFileLocation = loginModel.getResultsLocation();
			return ouputFileLocation;
		} catch (Exception e) {
			System.out.println("Could not find the results path");
			return "";
		}
	}

	public static boolean isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat("M/dd/yy");
			df.setLenient(true);
			df.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getFormattedDate(String date) {
		try {
			DateFormat df = new SimpleDateFormat("M/dd/yy");
			Date dateNew = df.parse(date);
			String formattedDate = df.format(dateNew);
			return formattedDate;
		} catch (Exception e) {
			return "";
		}
	}

	public static void writeCustomerTab(WebDriver d, CustomerListMetricsModel metricsModel)
			throws FileNotFoundException {

		Logger logger = LoggerFactory.getLogger(WriteCustomerTab.class);

		String outputPath = getOutputPath();
		ReadCustomerTab readCustomerCofig = new ReadCustomerTab();

		HashMap<Integer, HashMap<String, String>> metricsSuperMap = null;
		HashMap<String, String> metricsMap = null;

		SheetProvider sheetP = new SheetProvider();
		DataFormatter dataf = new DataFormatter();
		DateFormat df = new SimpleDateFormat("M/dd/yy");
		DateFormat df_1 = new SimpleDateFormat("YYYY_MM_dd");
		Date dateObj = new Date();
		int counter = 0;

		FileInputStream tempFile = null;
		Workbook tempWb = null;
		Sheet templateSheet = null;
		Sheet configSheet = null;

		try {

//			FileInputStream configFis = new FileInputStream("resources/config/config.properties");

			Properties prop = new Properties();
			prop.load(DriverClass.class.getResourceAsStream("/config/config.properties"));

			/*
			 * tempFile = new FileInputStream(WriteCustomerTab.class.getResource( outputPath
			 * + "\\UKI_QC_Results_"+df_1.format(dateObj)+".xlsx").getPath());
			 */

			InputStream resultFileStream = new FileInputStream(
					outputPath + "\\UKI_QC_Results_" + df_1.format(dateObj) + ".xlsx");

			logger.info("Loading the generated results template");
			tempWb = WorkbookFactory_Custom.createWorkBook(resultFileStream);

			logger.info("Getting to Customer Sheet");
			configSheet = sheetP.getSheetFromWorkbook(prop.getProperty("configFile"), "CUSTOMER");
			templateSheet = tempWb.getSheet("CUSTOMER");

			logger.info("Reading filter Values");
			metricsSuperMap = readCustomerCofig.readTab(d, configSheet);

			logger.info("Populating the results sheet");
			int lastRowNum = configSheet.getLastRowNum();

			Row mainRowTemp = templateSheet.getRow(1);
			Row mainRowConfig = configSheet.getRow(1);

			for (int l = 2; l < configSheet.getLastRowNum(); l++) {
				if (counter < metricsSuperMap.keySet().size()
						&& !(dataf.formatCellValue(configSheet.getRow(l).getCell(1)).equals(""))
						|| configSheet.getRow(l).getCell(1) == null) {
					if (counter < metricsSuperMap.keySet().size()) {
						Row row = templateSheet.getRow(l);
						Row confRow = configSheet.getRow(l);

						int cellsInMainRow = mainRowTemp.getLastCellNum() + 1;

						System.out.println(df.format(dateObj).toString());

						logger.info("Finding column with today's date to populate");
						for (int i = 1; i < cellsInMainRow; i++) {

							String cellValue = dataf.formatCellValue(mainRowTemp.getCell(i));

							logger.info("Checking for date value from the excel :" + cellValue);
							if (isDateValid(cellValue)) {
							/*	if (!(getFormattedDate(cellValue).equals("")) && getFormattedDate(cellValue) != null) {*/
									
									if (!(getFormattedDate(cellValue).equals("")) 
											&& getFormattedDate(cellValue) != null
												&& getFormattedDate(cellValue).equals(df.format(dateObj).toString())) {
										metricsMap = metricsSuperMap.get(counter);
										if (dataf.formatCellValue(confRow.getCell(12)).equals("Y")) {
											row.createCell(i).setCellValue(metricsMap.get("coverage"));
											
											logger.info("Deciding on threshold and data avaiability values");
											if (dataf.formatCellValue(mainRowConfig.getCell(13)).equals("THR")) {
												if (!(dataf.formatCellValue(confRow.getCell(15)).equals("NA"))) {
													if (Float.parseFloat(
															dataf.formatCellValue(row.getCell(i)).replace("%", "")) <= Float
																	.parseFloat(
																			dataf.formatCellValue(confRow.getCell(13))
																					.replace("%", ""))) {
														row.createCell(17).setCellValue("TRUE");
													} else {
														row.createCell(17).setCellValue("FALSE");
													}
												}
											}

											if (dataf.formatCellValue(mainRowConfig.getCell(12)).equals("AD")) {
												if (dataf.formatCellValue(confRow.getCell(12)).equals("Y")) {
													row.createCell(16).setCellValue("TRUE");
												} else {
													row.createCell(16).setCellValue("FALSE");
												}
											}
											
											break;
										}

										
									}
								
									
							}


						}
					}
				} else {
					break;
				}
				counter++;
			}

			OutputStream fileOut = new FileOutputStream(
					outputPath + "\\UKI_QC_Results_" + df_1.format(dateObj) + ".xlsx");

			logger.info("Writing to the output file");
			tempWb.write(fileOut);

			fileOut.close();
			configSheet.getWorkbook().close();
//			tempFile.close();
			tempWb.close();
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
}