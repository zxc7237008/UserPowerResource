package com.lovo.boot.bean;

import java.util.List;



public class PowerDtoReslut {
	
	private UserEntity user;
   
	private List<PowerDto> dto;

	public List<PowerDto> getDto() {
		return dto;
	}

	public void setDto(List<PowerDto> dto) {
		this.dto = dto;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
}
