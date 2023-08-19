package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JPRegisterdto {
	
	private String jpName;	
	private String userName;	
	private String password;
	private String email;
	private String address;
	private String webSite;
	private String phoneNo;
	public String getJpName() {
		return jpName;
	}
	public void setJpName(String jpName) {
		this.jpName = jpName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	

}
