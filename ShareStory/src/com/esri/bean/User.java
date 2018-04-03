package com.esri.bean;

public class User {
	private String uID;
	private String userName;
	@Override
	public String toString() {
		return "User [ userName=" + userName + ", password=" + password + "]";
	}

	private String password;

	public String getuID() {
		return uID;
	}

	public User(String uID, String userName, String password) {
		super();
		this.uID = uID;
		this.userName = userName;
		this.password = password;
	}

	public User() {
		super();
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
