package ToolsQATutorial;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestAssuredAPITest {
	
	@Test
	public void getBookDetails() {
		
		// This is the base URL to the RESful web service
		baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		Response response = get();
		
		
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Status code is => " +  response.getStatusCode());
		System.out.println("Response => " + response.prettyPrint());
				
	
	}
	
	@Test
	public void getBookDetails_2() {
		
		baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		given().
			get().
		then().
			statusCode(200). // This validates the status code, it compares the provided expected status code, 200 
							// to the actual status code, 200.
			log().all(); // This logs the the response (header and body)
	}

}
