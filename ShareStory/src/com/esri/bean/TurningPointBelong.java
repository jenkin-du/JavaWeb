package com.esri.bean;

public class TurningPointBelong {
	private String tBelongID;
	private String tPointID;
	private String routeID;
	private int number;

	@Override
	public String toString() {
		return "TurningpointBelong [tBelongID=" + tBelongID + ", tPointID=" + tPointID + ", routeID=" + routeID
				+ ", number=" + number + "]";
	}

	public TurningPointBelong(String tBelongID, String tPointID, String routeID, int number) {
		super();
		this.tBelongID = tBelongID;
		this.tPointID = tPointID;
		this.routeID = routeID;
		this.number = number;
	}

	public String gettBelongID() {
		return tBelongID;
	}

	public void settBelongID(String tBelongID) {
		this.tBelongID = tBelongID;
	}

	public String gettPointID() {
		return tPointID;
	}

	public void settPointID(String tPointID) {
		this.tPointID = tPointID;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
