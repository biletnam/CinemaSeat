package com.chinasoft.model.entity;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private String RId;
	private String RName;
	private Short RPower;

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** minimal constructor */
	public Roles(String RName) {
		this.RName = RName;
	}

	/** full constructor */
	public Roles(String RName, Short RPower) {
		this.RName = RName;
		this.RPower = RPower;
	}

	// Property accessors

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}

	public Short getRPower() {
		return this.RPower;
	}

	public void setRPower(Short RPower) {
		this.RPower = RPower;
	}

}