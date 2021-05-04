package com.riltest.request.model;

import java.io.Serializable;

public class AssetRequest implements Serializable{
	
	private static final long serialVersionUID = -2272836066008772172L;
	
	private int id;
	private String machineName;
	private String machineType;
	private String moneyCollected;
	private String itemRefilled;
	private String isServiceRequired;
	private int userId;

	public AssetRequest() {
		super();
	}

	/**
	 * @param id
	 * @param machineName
	 * @param machineType
	 * @param moneyCollected
	 * @param itemRefilled
	 */
	public AssetRequest(int id, String machineName, String machineType, String moneyCollected, String itemRefilled , String isServiceRequired , int userId) {
		super();
		this.id = id;
		this.machineName = machineName;
		this.machineType = machineType;
		this.moneyCollected = moneyCollected;
		this.itemRefilled = itemRefilled;
		this.isServiceRequired = isServiceRequired;
		this.userId = userId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the machineName
	 */
	public String getMachineName() {
		return machineName;
	}

	/**
	 * @param machineName the machineName to set
	 */
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	/**
	 * @return the machineType
	 */
	public String getMachineType() {
		return machineType;
	}

	/**
	 * @param machineType the machineType to set
	 */
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}

	/**
	 * @return the moneyCollected
	 */
	public String getMoneyCollected() {
		return moneyCollected;
	}

	/**
	 * @param moneyCollected the moneyCollected to set
	 */
	public void setMoneyCollected(String moneyCollected) {
		this.moneyCollected = moneyCollected;
	}

	/**
	 * @return the itemRefilled
	 */
	public String getItemRefilled() {
		return itemRefilled;
	}

	/**
	 * @param itemRefilled the itemRefilled to set
	 */
	public void setItemRefilled(String itemRefilled) {
		this.itemRefilled = itemRefilled;
	}

	/**
	 * @return the isServiceRequired
	 */
	public String getIsServiceRequired() {
		return isServiceRequired;
	}

	/**
	 * @param isServiceRequired the isServiceRequired to set
	 */
	public void setIsServiceRequired(String isServiceRequired) {
		this.isServiceRequired = isServiceRequired;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
