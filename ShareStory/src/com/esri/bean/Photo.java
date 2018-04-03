package com.esri.bean;

import java.sql.Time;

public class Photo {
	private String pID;
	private String tag;
	private String code;
	private Time uploadTime;

	public Time getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Time uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Photo [pID=" + pID + ", tag=" + tag + ", code=" + code + "]";
	}

	public Photo(String pID, String tag, String code) {
		super();
		this.pID = pID;
		this.tag = tag;
		this.code = code;
	}

}
