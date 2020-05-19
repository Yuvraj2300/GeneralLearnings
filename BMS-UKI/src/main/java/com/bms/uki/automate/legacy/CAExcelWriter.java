/*package com.bms.uki.automate.legacy;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CAExcelWriter extends Selenium {

	private static String[] columns_activity = { "Date", "F2F Calls", "Call Achievement %", "Reach %", "Frequency" };
	private static String[] columns_sales = { "Dashboard", "Sales vs Quota", "NBRx Market Share", "TRx Market Share" };
	// private static List Values = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException, IOException {
		String[] values = Seleniumrun();
		// String[]
		// values={"date","F2Fcalls","Call_achivement","Reach","Frequency","Province
		// Page","quota1" ,
		// "nbrx1" ,"trx1","Sales by District","quota2" ,"nbrx2","trx2"};

		try {

			String excelFilePath = "C:\\Users\\nb17392\\Desktop\\BMS Automation POC\\summary-file1.xlsx";
			FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Sheet sheet1 = workbook.getSheetAt(1);

			int rowNum = sheet.getLastRowNum();
			int rowNum1 = sheet1.getLastRowNum();
			// System.out.println(rowNum);
			System.out.println(rowNum + "num1" + rowNum1);
			Row row = sheet.createRow(rowNum + 1);
			Row row1 = sheet1.createRow(rowNum1 + 1);
			Row row2 = sheet1.createRow(rowNum1 + 2);
			Row row3 = sheet1.createRow(rowNum1 + 3);
			// System.out.println(rowNum);
			row.createCell(0).setCellValue(values[0]);
			row1.createCell(0).setCellValue(values[5]);
			row2.createCell(0).setCellValue(values[9]);
			row3.createCell(0).setCellValue("Status");

			row.createCell(1).setCellValue(values[1]);
			row1.createCell(1).setCellValue(values[6]);
			row2.createCell(1).setCellValue(values[10]);
			row3.createCell(1).setCellValue(values[6].equalsIgnoreCase(values[10]));

			row.createCell(2).setCellValue(values[2]);
			row1.createCell(2).setCellValue(values[7]);
			row2.createCell(2).setCellValue(values[11]);
			row3.createCell(2).setCellValue(values[7].equalsIgnoreCase(values[11]));

			row.createCell(3).setCellValue(values[3]);
			row1.createCell(3).setCellValue(values[8]);
			row2.createCell(3).setCellValue(values[12]);
			row3.createCell(3).setCellValue(values[8].equalsIgnoreCase(values[12]));

			row.createCell(4).setCellValue(values[4]);
			// System.out.println("Try is executed");
			// row1.createCell(4)
			// .setCellValue(sales[4]);

			for (int i = 0; i < columns_activity.length; i++) {
				sheet.autoSizeColumn(i);
				sheet1.autoSizeColumn(i);
			}

			FileOutputStream fileOut;

			fileOut = new FileOutputStream(excelFilePath);
			workbook.write(fileOut);
			fileOut.close();

			// Closing the workbook
			workbook.close();

			System.out.println("Excel updated");

			Component frame = null;
			// JOptionPane.showMessageDialog(frame, "Use Case 1 and 2 successfull");
			Object[] options = { "Yes", "No" };
			Object message = "Use Case 1 and 2 ran successfully , Do you want to view the result file ?";
			int n = JOptionPane.showOptionDialog(new JFrame(), message, "", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
			// int n = JOptionPane.YES_NO_OPTION ;
			if (n == JOptionPane.OK_OPTION) { // Afirmative

				File file = new File("C:\\Users\\nb17392\\Desktop\\BMS Automation POC\\summary-file1.xlsx");
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);

			}
			if (n == JOptionPane.NO_OPTION) {
				JOptionPane.getRootFrame().dispose();
			}

		} catch (Exception e) {
			// Create a Workbook
			System.out.println("Catch is executed");
			Workbook workbook = new XSSFWorkbook();
			CreationHelper createHelper = workbook.getCreationHelper();

			// Create a Sheet
			Sheet sheet = workbook.createSheet("Activity");
			Sheet sheet1 = workbook.createSheet("Sales");

			// Create a Font for styling header cells
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 14);
			headerFont.setColor(IndexedColors.RED.getIndex());

			Font StatusFont = workbook.createFont();
			StatusFont.setBold(true);
			StatusFont.setFontHeightInPoints((short) 14);
			StatusFont.setColor(IndexedColors.GREEN.getIndex());

			// Create a CellStyle with the font
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			CellStyle StatusCellStyle = workbook.createCellStyle();
			StatusCellStyle.setFont(StatusFont);

			// Create a Row
			Row headerRow = sheet.createRow(0);
			Row headerRow1 = sheet1.createRow(0);
			// System.out.println("HeaderRow"+headerRow);

			// Create cells
			for (int i = 0; i < columns_activity.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns_activity[i]);
				cell.setCellStyle(headerCellStyle);
				// System.out.println("Column_length"+columns.length);
				// System.out.println("Cell"+cell);
				// System.out.println(columns[i]);

			}

			for (int i = 0; i < columns_sales.length; i++) {
				Cell cell1 = headerRow1.createCell(i);
				cell1.setCellValue(columns_sales[i]);
				cell1.setCellStyle(headerCellStyle);
				// System.out.println("Column_length"+columns.length);
				// System.out.println("Cell"+cell);
				// System.out.println(columns[i]);

			}

			// Create Cell Style for formatting Date
			CellStyle dateCellStyle = workbook.createCellStyle();
			dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

			// Create Other rows and cells with employees data
			int rowNum = 0;
			// while(values.length==4) {
			Row row = sheet.createRow(rowNum + 1);
			Row row1 = sheet1.createRow(rowNum + 1);
			Row row2 = sheet1.createRow(rowNum + 2);
			Row row3 = sheet1.createRow(rowNum + 3);

			row.createCell(0).setCellValue(values[0]);
			row.createCell(1).setCellValue(values[1]);
			row.createCell(2).setCellValue(values[2]);
			row.createCell(3).setCellValue(values[3]);
			row.createCell(4).setCellValue(values[4]);

			row1.createCell(0).setCellValue(values[5]);
			row1.createCell(1).setCellValue(values[6]);
			row1.createCell(2).setCellValue(values[7]);
			row1.createCell(3).setCellValue(values[8]);

			row2.createCell(0).setCellValue(values[9]);
			row2.createCell(1).setCellValue(values[10]);
			row2.createCell(2).setCellValue(values[11]);
			row2.createCell(3).setCellValue(values[12]);

			row3.createCell(0).setCellValue("Status");
			row3.createCell(1).setCellValue(values[6].equalsIgnoreCase(values[10]));
			row3.createCell(2).setCellValue(values[7].equalsIgnoreCase(values[11]));
			row3.createCell(3).setCellValue(values[8].equalsIgnoreCase(values[12]));

			// }

			// Resize all columns to fit the content size
			for (int i = 0; i < columns_activity.length; i++) {
				sheet.autoSizeColumn(i);
			}

			for (int i = 0; i < columns_sales.length; i++) {
				sheet1.autoSizeColumn(i);
			}

			// Write the output to a file
			FileOutputStream fileOut;
			try {
				fileOut = new FileOutputStream("C:\\Users\\nb17392\\Desktop\\BMS Automation POC\\summary-file1.xlsx");
				workbook.write(fileOut);
				fileOut.close();

				// Closing the workbook
				workbook.close();

			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Component frame = null;

			Object[] options = { "Yes", "No" };
			Object message = "Use Case 1 and 2 ran successfully , Do you want to view the result file ?";
			int n = JOptionPane.showOptionDialog(new JFrame(), message, "", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			if (n == JOptionPane.OK_OPTION) { // Afirmative

				File file = new File("C:\\Users\\nb17392\\Desktop\\BMS Automation POC\\summary-file1.xlsx");
				Desktop desktop = Desktop.getDesktop();
				desktop.open(file);
			}
			if (n == JOptionPane.NO_OPTION) {
				JOptionPane.getRootFrame().dispose();
			}
		}

	}

}
*/