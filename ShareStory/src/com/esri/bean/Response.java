package com.esri.bean;

public class Response {

	private String code;
	private String jsonObj;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(String jsonObj) {
		this.jsonObj = jsonObj;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", jsonObj=" + jsonObj + "]";
	}

}
