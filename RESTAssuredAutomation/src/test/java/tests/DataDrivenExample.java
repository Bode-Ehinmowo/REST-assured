package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample extends DataForDataDrivenExamples {
	
	// Object data type is used as it can contain different types of data types
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "DataForPost")
	public void test_post(String firstName, String lastName, int subjectId) {
		
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
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
	
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "DataForPost2")
	public void test_post2(String firstName, String lastName, int subjectId) {
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
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
	
	
	@Test(dataProvider = "DataToDelete")
	public void test_delete(int userId) {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("users/" + userId).
		then().
			statusCode(200).
			log().all();
		
	}
	
}
