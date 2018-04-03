package com.esri.bean;

public class ThumbPhoto {
	
	private String uID;
	private String photoID;

	

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getPhotoID() {
		return photoID;
	}

	public void setPhotoID(String photoID) {
		this.photoID = photoID;
	}

	@Override
	public String toString() {
		return "Thumbphoto [uID=" + uID + ", photoID=" + photoID + "]";
	}

	public ThumbPhoto(String thumbID, String uID, String photoID) {
		super();
		this.uID = uID;
		this.photoID = photoID;
	}

}
