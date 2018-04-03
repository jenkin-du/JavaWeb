package com.esri.bean;

public class Location {
	private String id;
	private String province;
	private String city;
	private String zone;
	private String detail;
	private Float longtitude;
	private Float latitude;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}


	@Override
	public String toString() {
		return "Area [id=" + id + ", province=" + province + ", city=" + city + ", zone=" + zone + ", longtitude="
				+ longtitude + ", latitude=" + latitude + ", detail=" + detail + "]";
	}

	public Location(String id, String province, String city, String zone, String detail, Float longtitude,
			Float latitude) {
		super();
		this.id = id;
		this.province = province;
		this.city = city;
		this.zone = zone;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.detail = detail;
	}

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

}
