package com.chinasoft.model.entity;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String UId;
	private String AId;
	private String RId;
	private double UMoney;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String AId, String RId, double UMoney) {
		this.AId = AId;
		this.RId = RId;
		this.UMoney = UMoney;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getAId() {
		return this.AId;
	}

	public void setAId(String AId) {
		this.AId = AId;
	}

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public double getUMoney() {
		return this.UMoney;
	}

	public void setUMoney(double UMoney) {
		this.UMoney = UMoney;
	}

}