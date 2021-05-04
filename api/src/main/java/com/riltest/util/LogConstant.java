package com.riltest.util;

public final class LogConstant {
	
	private LogConstant() {
		
	}
	
	public static final String INVALID_USER_REQUEST = "Missing data for register user";
	public static final String FAILED_TO_REG_USER = "Failed to register user in database for email {}";
	public static final String EXCEPTION = "Exception occured while serving the request"; 
	public static final String INVALID_MACHINE_REQUEST = "Missing data for machine request";
	public static final String MACHINE_NOT_FOUND = "Machine not found for given id";
	public static final String FAILED_TO_UPDATE_MACHINE_INFO = "Failed to update machine info for id";

}
