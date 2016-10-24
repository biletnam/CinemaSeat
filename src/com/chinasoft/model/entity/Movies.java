package com.chinasoft.model.entity;

import java.util.Date;

/**
 * Movies entity. @author MyEclipse Persistence Tools
 */

public class Movies implements java.io.Serializable {

	// Fields

	private String MId;
	private String MName;
	private String MCountry;
	private String MState;
	private String MCategory;
	private String MReldate;
	private String MDirector;
	private String MActors;
	private Short MFitage;
	private Short MTime;
	private String MPicon;
	private String MIicon;
	private String MVideo;
	private Short MUnderstate;

	// Constructors

	/** default constructor */
	public Movies() {
	}

	/** full constructor */
	public Movies(String MName, String MCountry, String MState,
			String MCategory, String MReldate, String MDirector, String MActors,
			Short MFitage, Short MTime, String MPicon, String MIicon,
			String MVideo, Short MUnderstate) {
		this.MName = MName;
		this.MCountry = MCountry;
		this.MState = MState;
		this.MCategory = MCategory;
		this.MReldate = MReldate;
		this.MDirector = MDirector;
		this.MActors = MActors;
		this.MFitage = MFitage;
		this.MTime = MTime;
		this.MPicon = MPicon;
		this.MIicon = MIicon;
		this.MVideo = MVideo;
		this.MUnderstate = MUnderstate;
	}

	// Property accessors

	public String getMId() {
		return this.MId;
	}

	public void setMId(String MId) {
		this.MId = MId;
	}

	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

	public String getMCountry() {
		return this.MCountry;
	}

	public void setMCountry(String MCountry) {
		this.MCountry = MCountry;
	}

	public String getMState() {
		return this.MState;
	}

	public void setMState(String MState) {
		this.MState = MState;
	}

	public String getMCategory() {
		return this.MCategory;
	}

	public void setMCategory(String MCategory) {
		this.MCategory = MCategory;
	}

	public String getMReldate() {
		return this.MReldate;
	}

	public void setMReldate(String MReldate) {
		this.MReldate = MReldate;
	}

	public String getMDirector() {
		return this.MDirector;
	}

	public void setMDirector(String MDirector) {
		this.MDirector = MDirector;
	}

	public String getMActors() {
		return this.MActors;
	}

	public void setMActors(String MActors) {
		this.MActors = MActors;
	}

	public Short getMFitage() {
		return this.MFitage;
	}

	public void setMFitage(Short MFitage) {
		this.MFitage = MFitage;
	}

	public Short getMTime() {
		return this.MTime;
	}

	public void setMTime(Short MTime) {
		this.MTime = MTime;
	}

	public String getMPicon() {
		return this.MPicon;
	}

	public void setMPicon(String MPicon) {
		this.MPicon = MPicon;
	}

	public String getMIicon() {
		return this.MIicon;
	}

	public void setMIicon(String MIicon) {
		this.MIicon = MIicon;
	}

	public String getMVideo() {
		return this.MVideo;
	}

	public void setMVideo(String MVideo) {
		this.MVideo = MVideo;
	}

	public Short getMUnderstate() {
		return this.MUnderstate;
	}

	public void setMUnderstate(Short MUnderstate) {
		this.MUnderstate = MUnderstate;
	}

}