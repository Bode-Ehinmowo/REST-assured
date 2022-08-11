package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import static io.restassured.RestAssured.*;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ReadingDataFromExcelAPITest {
	
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	@SuppressWarnings("unchecked")
	@Test
	public void readExcel_Post() throws IOException {
		
		FileInputStream file = new FileInputStream("./data/TestData.xlsx");
		
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");
		
		int rowCount = sheet.getLastRowNum();
		
		for (int i = 1; i <= rowCount; i++) {
			
			DataFormatter formatter = new DataFormatter();
			
			Object firstName = formatter.formatCellValue(sheet.getRow(i).getCell(0));
			Object lastName = formatter.formatCellValue(sheet.getRow(i).getCell(1));
			Object subjectId = formatter.formatCellValue(sheet.getRow(i).getCell(2));
			
			
			JSONObject request = new JSONObject();
			request.put("firstName", firstName);
			request.put("lastName", lastName);
			request.put("subjectId", Integer.valueOf(subjectId.toString()));
			//System.out.println(request);
			
			baseURI = "http://localhost:3000/";
			
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				post("users").
			then().
				statusCode(201).
			log().all();
			
		}	
	}

}
