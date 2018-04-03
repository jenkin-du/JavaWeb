package com.esri.bean;

public class ThumbRoute {
	private String uID;
	private String routeID;

	public ThumbRoute(String thumbID, String uID, String routeID) {
		super();
		
		this.uID = uID;
		this.routeID = routeID;
	}

	

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	@Override
	public String toString() {
		return "Thumbroute [ uID=" + uID + ", routeID=" + routeID + "]";
	}

}
