package com.SwagLabs.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wd;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wd=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("File not found"+ e.getMessage());
		}	
	}
	
	
	public String getStringData(int row, int col, String sheetName)
	{
		XSSFSheet sheet1=wd.getSheet(sheetName);
		return sheet1.getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(int row, int col, int sheetIndex)
	{
		XSSFSheet sheet1=wd.getSheetAt(sheetIndex);
		return sheet1.getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(int row, int col, String sheetName)
	{
		XSSFSheet sheet1=wd.getSheet(sheetName);
		return sheet1.getRow(row).getCell(col).getNumericCellValue();
	}

}
