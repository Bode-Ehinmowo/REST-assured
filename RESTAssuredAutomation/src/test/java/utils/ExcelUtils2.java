package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelUtils2 {
	
	static HSSFWorkbook workbook;
	static HSSFSheet sheet;
	
	
	public ExcelUtils2(String excelPath, String sheetName) {
		
		try {
			
			InputStream file = new FileInputStream(excelPath);
			workbook = new HSSFWorkbook(new POIFSFileSystem(file));
			sheet = workbook.getSheet(sheetName);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}
	
	
	public static void getCellData(int rowNum, int colNum) {
		
			DataFormatter formatter = new DataFormatter();
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println(value);
		
	}
	
	
	public static void getRowCount() throws IOException {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No of rows is : " + rowCount);
	}

}
