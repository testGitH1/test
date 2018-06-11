package com.learn.rest.apis;


import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import java.util.Map;

import org.hamcrest.Matchers;
import io.restassured.path.json.JsonPath;;

public class SimpleGetTest {

	//	@Test
	public   void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		RestAssured.given().when().get("/Hyderabad").then().statusCode(200);

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		Map<String,	 String> map=response.getCookies();
		for(String key : map.keySet())
		{
			System.out.println(map.get(key));
		}

		//		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("products-schema.json"));

		//		 learning
		httpRequest.request(Method.GET, "/Hyderabad").then().assertThat().body("City", Matchers.equalTo("Hyderabad"));

		//		httpRequest.request(Method.GET, "/Hyderabad").then().body("", is("32.98 Degree celsius"));

		// Now let us print the body of the message to see what response
		// we have recieved from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		/*	SoftAssert soft = new SoftAssert();
	soft.assertEquals(response.getStatusCode(), 204); */	
		Assert.assertEquals(response.getStatusCode(), 200);
	}


	//	@Test
	public   void jsonPathExample()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "/Hyderabad");


		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);

		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");

		System.out.println("City received from Response " + city);

		Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
	}



	@Test
	public void DisplayAllNodesInWeatherAPI()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/Hyderabad");

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		System.out.println("City received from Response " + jsonPathEvaluator.get("City"));

		System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));

		System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));

		System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));

		System.out.println("Wind Speed received from Response " + jsonPathEvaluator.get("WindSpeed"));

		System.out.println("Direction Degree received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
	}

}