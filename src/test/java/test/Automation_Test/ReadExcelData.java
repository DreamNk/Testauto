package test.Automation_Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData  {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
		
	public  ReadExcelData(String excelpath) 
	{
	try {
		File src = new File (excelpath);  //       "D:\\LoginUsers.xlsx"
		
		FileInputStream fis = new FileInputStream(src);
		
		 wb = new XSSFWorkbook(fis);  	//HssfWorkbook for xls file
				
	} catch (Exception e) {// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
	}
			
	public String getData(int sheetnumber, int row, int column) 
	{
		sheet1 = wb.getSheetAt(sheetnumber); // index zero= 1st sheet
		String Data = sheet1.getRow(row).getCell(column).getStringCellValue();		
		return Data;		
	}
	
	public int getrowCount(int sheetnumber)
	{		
		int row = wb.getSheetAt(sheetnumber).getLastRowNum();
		row = row+1;		
		return row;
	}
	

}
