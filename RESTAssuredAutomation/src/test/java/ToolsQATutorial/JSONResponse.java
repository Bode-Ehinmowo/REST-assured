package ToolsQATutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSONResponse {
	
	public class JSONSuccessResponse { 

		// Note: The name should be exactly as the JSON node name 
		// Variable SuccessCode will contain value of SuccessCode node 
		public String SuccessCode; 

		// Variable Message will contain the value of Message node 
		public String Message; 
		}
	
	public class JSONFailureResponse {
		
		public String FaultId;
		public String fault;
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void UserRegistrationSuccessful() {
		
		baseURI ="https://demoqa.com";
		RequestSpecification request = RestAssured.given();
		
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("UserName", "test_rest");
		requestParams.put("Password", "rest@123");
		request.body(requestParams.toJSONString());
		Response response = request.post("/Account/v1/User");
		@SuppressWarnings("rawtypes")
		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());
		if(response.statusCode() == 200) { 

		// Deserialize the Response body into JSONFailureResponse 
		JSONFailureResponse responseBody = body.as(JSONFailureResponse.class); 

		// Use the JSONFailureResponse class instance to Assert the values of Response. 
		Assert.assertEquals("User already exists", responseBody.FaultId);
		Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault); 
		} else if (response.statusCode() == 201) { 

		// Deserialize the Response body into JSONSuccessResponse
		JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);

		// Use the JSONSuccessResponse class instance to Assert the values of response. 
		Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode); 
		Assert.assertEquals("Operation completed successfully", responseBody.Message); 
		} 
		}

}
