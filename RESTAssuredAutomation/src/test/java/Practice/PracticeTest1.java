package Practice;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PracticeTest1 {
	
	@Test
	public void test() {
		
		baseURI = "https://reqres.in";
		given().
			get("/api/unknown").
		then().
			statusCode(200);	
			
	}
	
	@Test
	public void test2 () {
		
		baseURI = "https://reqres.in";
		given().
			get("/api/unknown").
		then().
			body("data[1].name", equalTo("fuchsia rose"));
	}
	
}
