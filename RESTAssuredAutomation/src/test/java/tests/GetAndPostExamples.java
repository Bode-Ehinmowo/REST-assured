package tests;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAndPostExamples {
	
	@Test
	public void testGet() {
		
		baseURI = "https://reqres.in";		
		given().
			get("/api/users?page=2").
		then().
			statusCode(200).
			body("data[0].id", equalTo(7)).
			body("data[4].first_name", equalTo("George")).
			body("data.last_name", hasItems("Fields", "Ferguson", "Funke")).
			log().all();
		
	}
	@Test
	public void testPostMap1() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Sophie");
		map.put("job", "Doctor");
		System.out.println(map.toString());
		System.out.println(map);
		JSONObject request = new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString()); // no difference from request with no .toJSONString() method
	}
	
	@Test
	public void testPostMap2() {
		// Illustrating how to manipulate map data type to look like JSON data type
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("\"name\"", "\"Sophie\"");
		map.put("\"job\"", "\"Doctor\"");
		System.out.println(map.toString());
		System.out.println(map);	
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {
		JSONObject request = new JSONObject();
		request.put("name", "Sophie");
		request.put("job", "Doctor");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/json").
			// specifies the content type to be updated in the API
			contentType(ContentType.JSON). 
			// specifies the content type expected
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("api/users").
		then().
			statusCode(201).
			log().all();
		
	}

}
