package com.pjsoft.fms.dto;

import java.io.Serializable;

public class UserRequest implements Serializable{

	private static final long serialVersionUID = 1906411882941991504L;
	private String name;
	private String username;
	private String password;

	public UserRequest() {
	}

	public UserRequest(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
