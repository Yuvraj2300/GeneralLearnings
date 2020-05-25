package com.bms.uki.automate.xlwriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.bms.uki.automate.model.CustomerListMetricsModel;
import com.bms.uki.automate.xlwriter.utils.SheetProvider;
import com.bms.uki.automate.xlwriter.utils.WorkbookFactory_Custom;

public class WriteCustomerTab {
	
	public static void writeCustomerTab(CustomerListMetricsModel	metricsModel) throws FileNotFoundException {

		SheetProvider	sheetP	=	new SheetProvider();
		DataFormatter	dataf	=	new	DataFormatter();
		DateFormat df = new SimpleDateFormat("M/dd/yy");
		Date dateObj	=	new	Date();
		
		
		try {
			Sheet configSheet	= 
					sheetP.getSheetFromWorkbook("resources/UKI_QC_Config.xlsm", "CUSTOMER");
			Sheet	templateSheet	=
					sheetP.getSheetFromWorkbook("lib/xlFiles/UKI_QC_Results_Template.xlsx", "CUSTOMER");
			
			int lastRowNum	=	configSheet.getLastRowNum();
			
			
			Row mainRowTemp	=	templateSheet.getRow(1);
			Row mainRowConfig	=	configSheet.getRow(1);
			Row	row_1	=	templateSheet.getRow(2);
			Row	row_2	=	templateSheet.getRow(3);
			Row	row_3	=	templateSheet.getRow(4);
			
			int	cellsInMainRow	=	mainRowTemp.getLastCellNum()+1;
			
			
				/*row_1.createCell(1).setCellValue("GB");
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
				row_3.createCell(10).setCellValue("Coverage");*/
				
				
				System.out.println(df.format(dateObj).toString());
				
				
			
				
				for(int	i=1;i<cellsInMainRow;i++) {
					
					String cellValue	=	dataf.formatCellValue(mainRowConfig.getCell(i));
					
					if(cellValue.equals(df.format(dateObj).toString()))
					{
						if(dataf.formatCellValue(configSheet.getRow(1).getCell(12)).equals("Y")) {
							row_1.createCell(i).setCellValue(metricsModel.getCoverageUICV().toString());
						}
						
						if(dataf.formatCellValue(configSheet.getRow(2).getCell(12)).equals("Y")) {
							row_2.createCell(i).setCellValue(metricsModel.getCoverageUIIMM().toString());
						}
						
						if(dataf.formatCellValue(configSheet.getRow(3).getCell(12)).equals("Y")) {
							row_3.createCell(i).setCellValue(metricsModel.getCoverageUIONC().toString());
						}
						
						for(int j=i;j<cellsInMainRow;j++) {
							if(dataf.formatCellValue(mainRowConfig.getCell(j)).equals("THR")) {
								if(!(dataf.formatCellValue(row_1.getCell(j)).equals("NA"))){
									if(Float.parseFloat(dataf.formatCellValue(row_1.getCell(i)).replace("%", ""))	<	
											Float.parseFloat(dataf.formatCellValue(row_1.getCell(i)).replace("%", ""))) {
										row_1.createCell(j).setCellValue("TRUE");
									}else {
										row_1.createCell(j).setCellValue("FALSE");
									}
								}
								if(!(dataf.formatCellValue(row_2.getCell(j)).equals("NA"))){
									if(Float.parseFloat(dataf.formatCellValue(row_2.getCell(i)).replace("%", ""))	<	
											Float.parseFloat(dataf.formatCellValue(row_2.getCell(i)).replace("%", ""))) {
										row_2.createCell(j).setCellValue("TRUE");
									}else {
										row_2.createCell(j).setCellValue("FALSE");
									}
								}
								if(!(dataf.formatCellValue(row_3.getCell(j)).equals("NA"))){
									if(Float.parseFloat(dataf.formatCellValue(row_3.getCell(i)).replace("%", ""))	<	
											Float.parseFloat(dataf.formatCellValue(row_3.getCell(j)).replace("%", ""))) {
										row_3.createCell(j).setCellValue("TRUE");
									}else {
										row_3.createCell(j).setCellValue("FALSE");
									}
								}
								
							}else if(dataf.formatCellValue(mainRowConfig.getCell(j)).equals("AD")) {
								if(dataf.formatCellValue(row_1.getCell(j)).equals("Y")) {
									row_1.getCell(j).setCellValue("TRUE");
								}else {
									row_1.getCell(j).setCellValue("FALSE");
								}
								if(dataf.formatCellValue(row_2.getCell(j)).equals("Y")) {
									row_2.getCell(j).setCellValue("TRUE");
								}else {
									row_2.getCell(j).setCellValue("FALSE");
								}
								if(dataf.formatCellValue(row_3.getCell(j)).equals("Y")) {
									row_3.getCell(j).setCellValue("TRUE");
								}else {
									row_3.getCell(j).setCellValue("FALSE");
								}
							}
						}
					}
				}
				
				
				SimpleDateFormat df_1	=	new	 SimpleDateFormat("M_dd_yy");
				
				FileOutputStream	fileOut	=	
						new	FileOutputStream("lib/xlFiles/UKI_QC_Results_"+df_1.format(dateObj)+".xlsx");
				
				Workbook	wbOut	=	
						WorkbookFactory_Custom
							.createWorkBook(
									new FileInputStream(
											"lib/xlFiles/UKI_QC_Results_Template.xlsx"));
				wbOut.write(fileOut);
				wbOut.close();
				fileOut.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
		}
	}
}