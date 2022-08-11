package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenExampleParameters {
	
	@Parameters({"userId"})
	@Test
	public void test_delete2(int userId) {
		
		System.out.println("Value for userId is : " + userId);
		
		baseURI = "http://localhost:3000/";
		
		when().
			delete("users/" + userId).
		then().
			statusCode(200).
			log().all();
		
	}



}
