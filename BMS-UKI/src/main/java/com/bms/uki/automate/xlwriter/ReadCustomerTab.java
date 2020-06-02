package com.bms.uki.automate.xlwriter;

import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.site.CustomerMetricsParser;

public class ReadCustomerTab {
	public HashMap<Integer, HashMap<String, String>> readTab(WebDriver d, Sheet configSheet) {
		Logger	logger	=	LoggerFactory.getLogger(ReadCustomerTab.class);
		
		CustomerListMetricsModel metricsModel = new CustomerListMetricsModel();
		CustomerMetricsParser parserObj = new CustomerMetricsParser();
		HashMap<Integer, HashMap<String, String>> rowMap = new HashMap<>();
		HashMap<String, String> metricsMap;
		
		int mapCounter = 0;

		try {
			DataFormatter dataf = new DataFormatter();

			for (int i = 2; i < configSheet.getLastRowNum()-1; i++) {
				if (dataf.formatCellValue(configSheet.getRow(i).getCell(1)).equals("")
						|| configSheet.getRow(i).getCell(1) == null) {
					break;
				}
				
				metricsMap	= new HashMap<>();
				
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

			

				logger.info("Value Map Poulated, now setting the dropdown values");
				parserObj.setAllMetricsOnPage(d, 50, metricsMap);
				logger.info("Getting coverage value for the current filters");
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
