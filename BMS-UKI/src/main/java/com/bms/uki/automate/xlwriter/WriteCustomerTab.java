package com.bms.uki.automate.xlwriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.xlwriter.utils.SheetFactory;
import com.bms.uki.automate.xlwriter.utils.WorkbookFactory_Custom;

public class WriteCustomerTab {
	
	@SuppressWarnings("deprecation")
	public static void writeCustomerTab(CustomerListMetricsModel	metricsModel) throws FileNotFoundException {
		int	fillerRow	=	2;
		FileInputStream xlFile = new FileInputStream("lib/xlFiles/UKI_QC_Results.xlsx");
		DataFormatter	dataf	=	new	DataFormatter();
		DateFormat df = new SimpleDateFormat("M/dd/yy");
		Date dateObj	=	new	Date();
		
		
		try {
			Workbook wb = WorkbookFactory_Custom.createWorkBook(xlFile);
			Sheet sheet	=	SheetFactory.getSheet(wb, "CUSTOMER");
			int lastRowNum	=	sheet.getLastRowNum();
			
			Row mainRow	=	sheet.getRow(1);
			Row	row_1	=	sheet.createRow(fillerRow);
			Row	row_2	=	sheet.createRow(fillerRow+1);
			Row	row_3	=	sheet.createRow(fillerRow+2);
			
			int	cellsInMainRow	=	mainRow.getLastCellNum()+1;
			
			
				row_1.createCell(1).setCellValue("GB");
				row_2.createCell(1).setCellValue("GB");
				row_3.createCell(1).setCellValue("GB");
				
				row_1.createCell(2).setCellValue("Customer");
				row_2.createCell(2).setCellValue("Customer");
				row_3.createCell(2).setCellValue("Customer");
				
				row_1.createCell(3).setCellValue("Customer List");
				row_2.createCell(3).setCellValue("Customer List");
				row_3.createCell(3).setCellValue("Customer List");
				
				row_1.createCell(4).setCellValue("UI CV");
				row_2.createCell(4).setCellValue("UI ONC");
				row_3.createCell(4).setCellValue("UI IMM");
				
				row_1.createCell(5).setCellValue("HTD");
				row_2.createCell(5).setCellValue("HTD");
				row_3.createCell(5).setCellValue("HTD");
				
				row_1.createCell(6).setCellValue("Eliquis");
				row_2.createCell(6).setCellValue("Eliquis");
				row_3.createCell(6).setCellValue("Eliquis");
				
				row_1.createCell(7).setCellValue("All");
				row_2.createCell(7).setCellValue("All");
				row_3.createCell(7).setCellValue("All");
			
				row_1.createCell(8).setCellValue("All");
				row_2.createCell(8).setCellValue("All");
				row_3.createCell(8).setCellValue("All");
				
				row_1.createCell(9).setCellValue("All");
				row_2.createCell(9).setCellValue("All");
				row_3.createCell(9).setCellValue("All");
				
				row_1.createCell(10).setCellValue("Coverage");
				row_2.createCell(10).setCellValue("Coverage");
				row_3.createCell(10).setCellValue("Coverage");
				
				
				System.out.println(df.format(dateObj).toString());
				
				for(int	i=1;i<cellsInMainRow;i++) {
					
					String cellValue	=	dataf.formatCellValue(mainRow.getCell(i));
					
					if(cellValue.equals(df.format(dateObj).toString()))
					{
						row_1.createCell(i).setCellValue(metricsModel.getCoverageUICV());
						row_2.createCell(i).setCellValue(metricsModel.getCoverageUIIMM());
						row_3.createCell(i).setCellValue(metricsModel.getCoverageUIONC());
					}
				}
				
				FileOutputStream	fileOut	=	new	FileOutputStream("lib/xlFiles/UKI_QC_Results.xlsx");
				wb.write(fileOut);
				fileOut.close();
				xlFile.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
}
