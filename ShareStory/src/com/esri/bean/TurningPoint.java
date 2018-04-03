package com.esri.bean;

public class TurningPoint {
	private String tID;
	private Float longtitude;
	private Float latitude;

	public Float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Float longtitude) {
		this.longtitude = longtitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public String gettID() {
		return tID;
	}

	public void settID(String tID) {
		this.tID = tID;
	}

	public TurningPoint(String tID) {
		super();
		this.tID = tID;
	}

	@Override
	public String toString() {
		return "TurningPoint [tID=" + tID + ", longtitude=" + longtitude + ", latitude=" + latitude + "]";
	}
	
}
