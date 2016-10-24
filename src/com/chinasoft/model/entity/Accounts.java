package com.chinasoft.model.entity;

/**
 * Accounts entity. @author MyEclipse Persistence Tools
 */

public class Accounts implements java.io.Serializable {

	// Fields

	private String AId;
	private String AAccount;
	private String APassword;

	// Constructors

	/** default constructor */
	public Accounts() {
	}

	/** full constructor */
	public Accounts(String AAccount, String APassword) {
		this.AAccount = AAccount;
		this.APassword = APassword;
	}

	// Property accessors

	public String getAId() {
		return this.AId;
	}

	public void setAId(String AId) {
		this.AId = AId;
	}

	public String getAAccount() {
		return this.AAccount;
	}

	public void setAAccount(String AAccount) {
		this.AAccount = AAccount;
	}

	public String getAPassword() {
		return this.APassword;
	}

	public void setAPassword(String APassword) {
		this.APassword = APassword;
	}

}