package com.learn.pojo;

public class RegistrationSuccessResponse {


	// Variable where value of SuccessCode node
	// will be copied
	// Note: The name should be exactly as the node name is 
	// present in the Json
	
	public String SuccessCode;

	// Variable where value of Message node will
	// be copied
	// Note: The name should be exactly as the node name is 
	// present in the Json
	
	public String Message;
	
	@Override
	public String toString() 
	{
		
		return "Success Code is "+SuccessCode + "  Message is "+Message;
	}
	

	
}
