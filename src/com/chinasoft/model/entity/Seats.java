package com.chinasoft.model.entity;

/**
 * Seats entity. @author MyEclipse Persistence Tools
 */

public class Seats implements java.io.Serializable {

	// Fields

	private String seId;
	private String MId;
	private String SId;
	private String seState;

	// Constructors

	/** default constructor */
	public Seats() {
	}

	/** full constructor */
	public Seats(String MId, String SId, String seState) {
		this.MId = MId;
		this.SId = SId;
		this.seState = seState;
	}

	// Property accessors

	public String getSeId() {
		return this.seId;
	}

	public void setSeId(String seId) {
		this.seId = seId;
	}

	public String getMId() {
		return this.MId;
	}

	public void setMId(String MId) {
		this.MId = MId;
	}

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	public String getSeState() {
		return this.seState;
	}

	public void setSeState(String seState) {
		this.seState = seState;
	}

}