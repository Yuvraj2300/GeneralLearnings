package com.bms.uki.automate.model;
//depracated
public class LoginPageModel {
	private String username;
	private String password;

	public LoginPageModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public LoginPageModel LoginPage(String username, String password) {
		return new LoginPageModel(username, password);
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
