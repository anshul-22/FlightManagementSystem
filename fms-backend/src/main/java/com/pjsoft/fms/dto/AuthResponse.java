package com.pjsoft.fms.dto;

import java.io.Serializable;

public class AuthResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3125508913831859294L;
	private String username;
	private String token;
	public AuthResponse(String username, String token) {
		super();
		this.username = username;
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
