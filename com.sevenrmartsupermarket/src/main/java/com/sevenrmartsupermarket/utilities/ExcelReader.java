package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sevenrmartsupermarket.constants.Constants;

public class ExcelReader {

	XSSFSheet sheet;
	XSSFWorkbook workbook;

	XSSFRow row;
	XSSFCell cell;

	public void setExcelFile(String workBookName, String sheetName) {

		try {

			String path = Constants.EXCEL_FILE_PATH + workBookName + ".xlsx";

			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCell_Data(int rowNo, int columnNo) {
		row = sheet.getRow(rowNo);
		cell = row.getCell(columnNo);

		switch (cell.getCellType()) {
		case STRING: {
			String data;
			data = cell.getStringCellValue();
			return data;
		}
		case NUMERIC: {
			long d = (long) cell.getNumericCellValue();
			return String.valueOf(d);
		}

		default:
			return null;

		}
	}
	
	/** provide data to dataprovider from excel**/
	public  Object[][] getMultidimentionalData(int row, int column)
	{
		Object userdata[][] = new Object[row][column];
		for (int i = 0; i <row; i++) {
			for (int j = 0; j < column; j++) {
				
				userdata[i][j]=getCell_Data(i, j);
			}
	}
		return userdata;
}
}
