package com.riltest.request.model;

import java.io.Serializable;

public class UserRequest implements Serializable{
	
	private static final long serialVersionUID = -1650454604538600458L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String userType;
	
	/**
	 * No-arg Constructor 
	 */
	public UserRequest() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param userType
	 */
	public UserRequest(String firstName, String lastName, String email, String userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userType = userType;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}
