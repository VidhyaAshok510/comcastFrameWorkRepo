package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdatafile.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String data= wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
	
}
public int getRowCount(String sheetName) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdatafile.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowCount= wb.getSheet(sheetName).getLastRowNum();
	wb.close();
	return rowCount;
	
}
public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable, IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/testdata/testdatafile.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./testdata/testdatafile.xlsl");
	wb.write(fos);
	wb.close();
}
}
