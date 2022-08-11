package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ExamplesUsingLocalMockAPI {
	
	@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		
		given().
			header("Content-Type", "application.json").
			get("users").
		then().
			statusCode(200).
			log().all();
	
	}
	
	@Test
	public void test_get2() {
		
	// Showing the use of param() method
		
		baseURI = "http://localhost:3000/";
		
		given().
			// similar to doing http://localhost:3000/subjects?name=Automation
			param("name", "Automation"). 
			get("subjects").
		then().
			statusCode(200).
			log().all();
	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_post() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Abisoye");
		request.put("lastName", "Adakomola");
		request.put("subjectId", 1);
		
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
	@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("lastName", "Festus-Adakomola");
		
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("users/4").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_put() {
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Bisoye");
		request.put("lastName", "Adakomola");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("users/4").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("users/4").
		then().
			statusCode(200).
			log().all();
		
	}

}
