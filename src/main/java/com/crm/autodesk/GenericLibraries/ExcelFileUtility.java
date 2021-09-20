package com.crm.autodesk.GenericLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods to read and write from Excel sheet
 * @author DEEPAK LENKA
 *
 */
public class ExcelFileUtility {
	/**
	 * this method will read data from excel sheet
	 * @throws Throwable 
	 */
  public String getExcelData(String sheetname,int rownum,int cellnum) throws Throwable {
	  FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
	  Workbook book= WorkbookFactory.create(fis);
	  Sheet sh=book.getSheet(sheetname);
	  Row row=sh.getRow(rownum);
	  Cell cell=row.getCell(cellnum);
	  String value=cell.getStringCellValue();
	  return value;
	  
 }
  /**
   * this method return data full in sheet
   * @param sheetname
   * @throws Throwable
   */
  public Object[][] getExceldata(String sheetname) throws Throwable  
  {
	  FileInputStream fis= new FileInputStream(IPathConstants.ExcelPath);
	  Workbook book=WorkbookFactory.create(fis);
	  Sheet sh=book.getSheet(sheetname);
	  int lastrow=sh.getLastRowNum();
	  int lastcell=sh.getRow(0).getLastCellNum();
	  Object[][] data=new Object[lastrow][lastcell];
	  for(int i=0;i< lastrow;i++) 
	  {
		  
		  for(int j=0;j<lastcell;j++) 
		  {
			  
			data[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();
		  }
		  
	  }
	  
	  return data;
  }
}
