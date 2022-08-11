package tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
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
			put("api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {
		JSONObject request = new JSONObject();
		request.put("name", "morpheus");
		request.put("job", "zion resident");
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
			patch("api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in";

		when().
			delete("api/users/2").
		then().
			statusCode(204).
			log().all();
		
	}

}
