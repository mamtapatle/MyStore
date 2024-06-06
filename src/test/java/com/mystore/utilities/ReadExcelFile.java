package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static FileInputStream inputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelsheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo/*column no.*/)
	{

		try
		{

			inputstream = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(inputstream);
			excelsheet =  workbook.getSheet(sheetName);
			cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

			workbook.close();

			return cell.getStringCellValue();

		}

		catch (Exception e)

		{
			return "";

		}
	}

	public static int getRowCount (String fileName, String sheetName)
	{

		try

		{

			inputstream = new FileInputStream(fileName);
			//create XSSFWorkBook Class object for excel file manipulation

			workbook = new XSSFWorkbook(inputstream);
			excelsheet =  workbook.getSheet(sheetName);

			//get total no. of rows
			int ttlRows = excelsheet.getLastRowNum() + 1;

			workbook.close();

			return ttlRows;

		}

		catch (Exception e)

		{

			return 0;

		}

	}

	public static int getColCount (String fileName, String sheetName)
	{

		try

		{

			FileInputStream inputStream = new FileInputStream(fileName);
			//create XSSFWorkBook Class object for excel file manipulation
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet excelSheet =  workBook.getSheet(sheetName);

			//get total no. of columns
			int ttlCells = excelSheet.getRow(0).getLastCellNum();

			workBook.close();
			return ttlCells;

		}

		catch (Exception e)

		{

			return 0;

		}

	}	
	
		
		
	

}


