package com.demo.restaurants.demo.formbean;

public class UserForm {
	
	private String userName;

	private String pass;
	
	public UserForm() {}

	public UserForm(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
