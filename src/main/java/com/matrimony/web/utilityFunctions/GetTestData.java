package com.matrimony.web.utilityFunctions;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GetTestData {
	
	/* This class helps to read data from Test data file */
	
    static FileInputStream file = null;
    static Workbook book;
    static Sheet sheet;
	static String TestData_Sheet_Path = "./src/test/resources/test-data/MatrimonyTestData.xlsx";
//	static String TestData_Sheet_Path = "./src/test/resources/test-data/MatrimonyTestData.csv";
	
	public static Object[][] getTestData(String sheetName) {
		
		try {
	        file = new FileInputStream(TestData_Sheet_Path);
        }catch(FileNotFoundException e) {
	        e.printStackTrace();
        }

        try {
	        book = WorkbookFactory.create(file);
        }catch (Exception e) {
        	e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        
        for(int i = 0 ; i< sheet.getLastRowNum(); i++) {
	        for(int j = 0; j < sheet.getRow(0).getLastCellNum(); j++ ) {
	        data[i][j] = sheet.getRow(i+1).getCell(j).toString();
	        }
        }
        
		return data;
	}
	
}
