package com.bms.uki.automate.xlwriter;

import java.io.FileInputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.site.CustomerMetricsParser;
import com.bms.uki.automate.xlwriter.utils.SheetFactory;
import com.bms.uki.automate.xlwriter.utils.WorkbookFactory_Custom;

public class ReadCustomerTab {
	public HashMap<Integer, HashMap<String, String>> readTab(WebDriver d, Sheet configSheet) {
		CustomerListMetricsModel metricsModel = new CustomerListMetricsModel();
		CustomerMetricsParser parserObj = new CustomerMetricsParser();
		HashMap<Integer, HashMap<String, String>> rowMap = new HashMap<>();
		HashMap<String, String> metricsMap = new HashMap<>();
		
		int mapCounter = 0;

		try {
//			Workbook wb = WorkbookFactory_Custom.createWorkBook(new FileInputStream("resources/UKI_QC_Config.xlsm"));
//			SheetFactory sf = new SheetFactory();
//			Sheet sheet = sf.getSheet(wb, "CUSTOMER");

			DataFormatter dataf = new DataFormatter();

			for (int i = 2; i < configSheet.getLastRowNum()-1; i++) {
				if (dataf.formatCellValue(configSheet.getRow(i).getCell(1)).equals("")
						|| configSheet.getRow(i).getCell(1) == null) {
					break;
				}
				metricsModel.setGeography(dataf.formatCellValue(configSheet.getRow(i).getCell(4)));
				metricsMap.put("geography", metricsModel.getGeography());

				metricsModel.setTimePeriod(dataf.formatCellValue(configSheet.getRow(i).getCell(5)));
				metricsMap.put("time period", metricsModel.getTimePeriod());

				metricsModel.setProduct(dataf.formatCellValue(configSheet.getRow(i).getCell(6)));
				metricsMap.put("product", metricsModel.getProduct());

				metricsModel.setSegment(dataf.formatCellValue(configSheet.getRow(i).getCell(7)));
				metricsMap.put("segment", metricsModel.getSegment());

				metricsModel.setTier(dataf.formatCellValue(configSheet.getRow(i).getCell(8)));
				metricsMap.put("tier", metricsModel.getTier());

				metricsModel.setTimeSeen(dataf.formatCellValue(configSheet.getRow(i).getCell(9)));
				metricsMap.put("time seen", metricsModel.getTimeSeen());

			

				
				parserObj.setAllMetricsOnPage(d, 50, metricsMap);
				metricsMap.put("coverage", parserObj.getCoverageValue(d, 50));

				rowMap.put(mapCounter, metricsMap);
				mapCounter++;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowMap;
	}
}
