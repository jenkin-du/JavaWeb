package com.esri.bean;

public class Route {
	private String rID;
	private String catalog;
	private String totalNumber;

	public Route(String rID, String catalog, String totalNumber) {
		super();
		this.rID = rID;
		this.catalog = catalog;
		this.totalNumber = totalNumber;
	}

	@Override
	public String toString() {
		return "Route [rID=" + rID + ", catalog=" + catalog + ", totalNumber=" + totalNumber + "]";
	}

	public String getrID() {
		return rID;
	}

	public void setrID(String rID) {
		this.rID = rID;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}
}
