package com.learn.rest.apis;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learn.pojo.RegistrationFailureResponse;
import com.learn.pojo.RegistrationSuccessResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePostTest 
{
	@Test
	public void RegistrationSuccessful() throws JSONException
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		String random =RandomStringUtils.randomAlphabetic(5);
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Viresdsadsdnsdfdefdsgsfdgsfdgr1CT"); // Cast
		requestParams.put("LastName", "Singfdsfdsgfgh");
		requestParams.put("UserName", "sample"+random+"user");  // unique
		requestParams.put("Password", "passwofdsfsdsgfdgfdgsfdrd1");

		requestParams.put("Email",  "sample"+random+"@gmail.com");   // +unique
		System.err.println(requestParams.toString());
		request.body(requestParams.toString());
		Response response = request.post("/register");
		
		RegistrationSuccessResponse responseBody = response.as(RegistrationSuccessResponse.class);
		
		System.err.println(responseBody.toString());
		
//		int statusCode = response.getStatusCode();
		/*
		System.err.println(response.getBody().asString());
		
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		System.err.println("successCode      " +successCode);
		Assert.assertEquals( successCode, "OPERATION_SUCCESS" ,"Correct Success code was returned");*/
		
		
		if(response.statusCode() == 200)
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody1 = response.as(RegistrationFailureResponse.class);
	 
			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("User already exists", responseBody1.getFaultId());
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody1.getFault());	
		}
		else if (response.statusCode() == 201)
		{
			// Deserialize the Response body into RegistrationSuccessResponse
			  responseBody = response.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	
		}	
	}
}
