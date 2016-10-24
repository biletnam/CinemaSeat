package com.chinasoft.model.entity;

/**
 * Seasons entity. @author MyEclipse Persistence Tools
 */

public class Seasons implements java.io.Serializable {

	// Fields

	private String SId;
	private String MId;
	private String SShowdate;
	private String SBegintime;
	private String SEndtime;
	private String SVersion;
	private Double SPrice;

	// Constructors

	/** default constructor */
	public Seasons() {
	}

	/** minimal constructor */
	public Seasons(String MId, Double SPrice) {
		this.MId = MId;
		this.SPrice = SPrice;
	}

	/** full constructor */
	public Seasons(String MId, String SShowdate, String SBegintime, String SEndtime,
			String SVersion, Double SPrice) {
		this.MId = MId;
		this.SShowdate = SShowdate;
		this.SBegintime = SBegintime;
		this.SEndtime = SEndtime;
		this.SVersion = SVersion;
		this.SPrice = SPrice;
	}

	// Property accessors

	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	public String getMId() {
		return this.MId;
	}

	public void setMId(String MId) {
		this.MId = MId;
	}

	public String getSShowdate() {
		return this.SShowdate;
	}

	public void setSShowdate(String SShowdate) {
		this.SShowdate = SShowdate;
	}

	public String getSBegintime() {
		return this.SBegintime;
	}

	public void setSBegintime(String SBegintime) {
		this.SBegintime = SBegintime;
	}

	public String getSEndtime() {
		return this.SEndtime;
	}

	public void setSEndtime(String SEndtime) {
		this.SEndtime = SEndtime;
	}

	public String getSVersion() {
		return this.SVersion;
	}

	public void setSVersion(String SVersion) {
		this.SVersion = SVersion;
	}

	public Double getSPrice() {
		return this.SPrice;
	}

	public void setSPrice(Double SPrice) {
		this.SPrice = SPrice;
	}

	@Override
	public String toString() {
		return "Seasons [SId=" + SId + ", MId=" + MId + ", SShowdate="
				+ SShowdate + ", SBegintime=" + SBegintime + ", SEndtime="
				+ SEndtime + ", SVersion=" + SVersion + ", SPrice=" + SPrice
				+ "]";
	}

	
	
}