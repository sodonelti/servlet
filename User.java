package com.lti.training.day6.collections;

public class User {

	private String username;
	private String password;
	private String active;
	
	public User() {
	}
	public User(String username, String password, String active) {
		this.username = username;
		this.password = password;
		this.active = active;
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
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
}
