package com.riltest.response.model;

import java.io.Serializable;

public class Response implements Serializable{
	
	private static final long serialVersionUID = 3948497572720209007L;
	
	private boolean status;
	private String code;
	private Object object;
	
	public Response() {
		super();
	}

	/**
	 * @param status
	 * @param code
	 * @param object
	 */
	public Response(boolean status, String code, Object object) {
		super();
		this.status = status;
		this.code = code;
		this.object = object;
	}
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	
}
