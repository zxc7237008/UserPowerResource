package com.lovo.boot.bean;

public class PowerDto {
     private String userName;
     private String powerUri;
     
     public PowerDto(){}
	public PowerDto(String userName, String powerUri) {
		super();
		this.userName = userName;
		this.powerUri = powerUri;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPowerUri() {
		return powerUri;
	}
	public void setPowerUri(String powerUri) {
		this.powerUri = powerUri;
	}
     
     
}
