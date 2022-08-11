package utils;

import java.io.IOException;

public class ExcelUtilsTest2 {
	
	public static void main(String[] args) throws IOException {
		
		String excelPath = "./data/TestData.xls";
		String sheetName = "Sheet1";
		
		ExcelUtils2 excel = new ExcelUtils2(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(1, 0);
		excel.getCellData(1, 1);
		excel.getCellData(1, 2);
		
		
		

	}

}
