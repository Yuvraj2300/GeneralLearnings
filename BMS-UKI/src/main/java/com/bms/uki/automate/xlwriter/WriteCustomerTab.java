package com.bms.uki.automate.xlwriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.xlwriter.utils.SheetProvider;
import com.bms.uki.automate.xlwriter.utils.WorkbookFactory_Custom;

public class WriteCustomerTab {

	public static void writeCustomerTab(WebDriver d, CustomerListMetricsModel metricsModel)
			throws FileNotFoundException {

		ReadCustomerTab readCustomerCofig = new ReadCustomerTab();

		HashMap<Integer, HashMap<String, String>> metricsSuperMap = null;
		HashMap<String, String> metricsMap = null;

		SheetProvider sheetP = new SheetProvider();
		DataFormatter dataf = new DataFormatter();
		DateFormat df = new SimpleDateFormat("M/dd/yy");
		DateFormat df_1 = new SimpleDateFormat("YYYY_MM_dd");
		Date dateObj = new Date();

		FileInputStream tempFile = null;
		Workbook tempWb = null;
		Sheet templateSheet = null;
		Sheet configSheet = null;

		try {
			tempFile = new FileInputStream("lib/xlFiles/UKI_QC_Results_"+df_1.format(dateObj)+".xlsx");
			tempWb = WorkbookFactory_Custom.createWorkBook(tempFile);

			configSheet = sheetP.getSheetFromWorkbook("resources/UKI_QC_Config.xlsm", "CUSTOMER");
			templateSheet = tempWb.getSheet("CUSTOMER");

			metricsSuperMap = readCustomerCofig.readTab(d, configSheet);

			int lastRowNum = configSheet.getLastRowNum();

			Row mainRowTemp = templateSheet.getRow(1);
			Row mainRowConfig = configSheet.getRow(1);
			Row row_1 = templateSheet.getRow(2);
			Row row_2 = templateSheet.getRow(3);
			Row row_3 = templateSheet.getRow(4);

			Row confRow_1 = configSheet.getRow(2);
			Row confRow_2 = configSheet.getRow(3);
			Row confRow_3 = configSheet.getRow(4);

			int cellsInMainRow = mainRowTemp.getLastCellNum() + 1;

			System.out.println(df.format(dateObj).toString());

			for (int i = 1; i < cellsInMainRow; i++) {

				String cellValue = dataf.formatCellValue(mainRowTemp.getCell(i));

				if (cellValue.equals(df.format(dateObj).toString())) {
					for (int k = 0; k < metricsSuperMap.keySet().size(); k++) {
						metricsMap = metricsSuperMap.get(k);

						if (dataf.formatCellValue(confRow_1.getCell(12)).equals("Y")) {
							row_1.createCell(i).setCellValue(metricsMap.get("coverage"));
						}

						if (dataf.formatCellValue(confRow_2.getCell(12)).equals("Y")) {
							row_2.createCell(i).setCellValue(metricsMap.get("coverage"));
						}

						if (dataf.formatCellValue(confRow_3.getCell(12)).equals("Y")) {
							row_3.createCell(i).setCellValue(metricsMap.get("coverage"));
						}
					}
					if (dataf.formatCellValue(mainRowConfig.getCell(13)).equals("THR")) {
						if (!(dataf.formatCellValue(confRow_1.getCell(15)).equals("NA"))) {
							if (Float.parseFloat(dataf.formatCellValue(row_1.getCell(i)).replace("%", "")) < Float
									.parseFloat(dataf.formatCellValue(confRow_1.getCell(13)).replace("%", ""))) {
								row_1.createCell(17).setCellValue("TRUE");
							} else {
								row_1.createCell(17).setCellValue("FALSE");
							}
						}
						if (!(dataf.formatCellValue(confRow_2.getCell(13)).equals("NA"))) {
							if (Float.parseFloat(dataf.formatCellValue(row_2.getCell(i)).replace("%", "")) < Float
									.parseFloat(dataf.formatCellValue(confRow_2.getCell(13)).replace("%", ""))) {
								row_2.createCell(17).setCellValue("TRUE");
							} else {
								row_2.createCell(17).setCellValue("FALSE");
							}
						}
						if (!(dataf.formatCellValue(confRow_3.getCell(13)).equals("NA"))) {
							if (Float.parseFloat(dataf.formatCellValue(row_3.getCell(i)).replace("%", "")) < Float
									.parseFloat(dataf.formatCellValue(confRow_3.getCell(13)).replace("%", ""))) {
								row_3.createCell(17).setCellValue("TRUE");
							} else {
								row_3.createCell(17).setCellValue("FALSE");
							}
						}

					} else if (dataf.formatCellValue(mainRowConfig.getCell(12)).equals("AD")) {
						if (dataf.formatCellValue(confRow_1.getCell(12)).equals("Y")) {
							row_1.getCell(16).setCellValue("TRUE");
						} else {
							row_1.getCell(16).setCellValue("FALSE");
						}
						if (dataf.formatCellValue(confRow_2.getCell(12)).equals("Y")) {
							row_2.getCell(16).setCellValue("TRUE");
						} else {
							row_2.getCell(16).setCellValue("FALSE");
						}
						if (dataf.formatCellValue(confRow_3.getCell(12)).equals("Y")) {
							row_3.getCell(16).setCellValue("TRUE");
						} else {
							row_3.getCell(16).setCellValue("FALSE");
						}
					}
				}
			}


			FileOutputStream fileOut = new FileOutputStream("lib/xlFiles/UKI_QC_Results_2020_05_26.xlsx");

			tempWb.write(fileOut);
			tempWb.close();
			configSheet.getWorkbook().close();
			tempFile.close();
			fileOut.close();

		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
}