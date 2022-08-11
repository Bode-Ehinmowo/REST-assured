package ToolsQATutorial;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ValidatingRestAPIHeader {
	
	@Test
	public void iteratingHeaders() {
		
		baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		Response response = get();
		// Get all the headers
		Headers allheaders = response.headers();
		// Iterate over all the headers to print each header
		for (Header header : allheaders) {
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}	
	}
	
	@Test
	public void getBookHeaders() {
		
		/* Accessing Content-Type,  Server, and Content-Encoding headers 
		by specifying respective headers names as an argument to the header() method. */
		
		baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		Response response = get();
		
		// Access header with a given name, Content-Type 
		String contentType = response.header("Content-Type"); 
		System.out.println("Content-Type value: " + contentType); 
		
		// Access header with a given name, Server 
		String serverType = response.header("Server"); 
		System.out.println("Server value: " + serverType); 
		
		// Access header with a given name. Header = Content-Encoding 
		String acceptLanguage = response.header("Content-Encoding"); 
		System.out.println("Content-Encoding: " + acceptLanguage); 
	}
	
	@Test
	public void validateBookHeaders() {
		
		baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		Response response = get();
		
		// Access header with a given name. Header = Content-Type 
		String contentType = response.header("Content-Type"); 
		Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */); 
		
		// Access header with a given name. Header = Server 
		String serverType = response.header("Server"); 
		Assert.assertEquals(serverType /* actual value */, "nginx/1.17.10 (Ubuntu)" /* expected value */);
		
	}
	
	
	
	
	

}
