package com.esri.bean;

public class PhotoBelong {
	private String photoID;
	private String routeID;
	public String getPhotoID() {
		return photoID;
	}
	public void setPhotoID(String photoID) {
		this.photoID = photoID;
	}
	public String getRouteID() {
		return routeID;
	}
	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}
	@Override
	public String toString() {
		return "PhotoBelong [photoID=" + photoID + ", routeID=" + routeID + "]";
	}

	
}
