package ToolsQATutorial;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ValidatingRestAPIBody {
	
	@SuppressWarnings("rawtypes")
	@Test
	public void WeatherMessageBody() {
		
		baseURI = "https://demoqa.com/BookStore/v1";
		
		Response response = get("/Books");
		
		// Retrieve the body of the Response
		ResponseBody body = response.body();
		
		// By using the ResponseBody.asString() method/.asPrettyString() method, we can convert the  body
		// into the string representation.
		String bodyAsString = body.asPrettyString();
		
		// convert the body into lower case and then do a comparison to ignore casing.
		Assert.assertEquals(bodyAsString.toLowerCase().contains("books") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
		
		
	}

}
