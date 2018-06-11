package com.learn.pojo;

public class RegistrationFailureResponse 
{
	private String FaultId;
	private String fault;
	
	public String getFaultId() {
		return FaultId;
	}
	public void setFaultId(String faultId) {
		FaultId = faultId;
	}
	public String getFault() {
		return fault;
	}
	public void setFault(String fault) {
		this.fault = fault;
	}
}
