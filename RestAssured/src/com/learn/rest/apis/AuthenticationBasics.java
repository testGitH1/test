package com.learn.rest.apis;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


/**
 * Authentication in API using Rest Assured 
 * 
 * @author AnilJ
 *
 */
public class AuthenticationBasics 
{

	public static void main(String[] args) 
	{
		
		RestAssured.authentication = RestAssured.basic("ToolsQA", "TestPassword");

		RestAssured.baseURI  = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();

//		below line is alternative 
//		RequestSpecification request = RestAssured.given().auth().basic("ToolsQA", "TestPassword");
		
		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}

}
