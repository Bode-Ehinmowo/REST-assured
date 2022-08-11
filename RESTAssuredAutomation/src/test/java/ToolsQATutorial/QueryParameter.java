package ToolsQATutorial;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void queryPam() {
		
		baseURI = "https://bookstore.toolsqa.com/BookStore/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Passing the resource details
		Response response = httpRequest.queryParam("ISBN","9781449325862").get("/Book");
		//Retrieving the response body using body() method
		ResponseBody body = response.body();
		//Converting the response body to string object
		String stringBody = body.asPrettyString();
		System.out.println(stringBody);
		//Creating object of JsonPath and passing the string response body as parameter
		JsonPath jpath = new JsonPath(stringBody);
		//Storing book title in a string variable
		String title = jpath.getString("title");
		System.out.println("The book title is - "+title);
		
		
		
	}

}
