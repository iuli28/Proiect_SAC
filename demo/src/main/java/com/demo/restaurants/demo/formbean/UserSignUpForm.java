package com.demo.restaurants.demo.formbean;

import javax.validation.constraints.NotEmpty;

public class UserSignUpForm {
	
	private String userName;

	private String password;

	private String nume;

	private String prenume;
	
	private String email;
	
	private String phone;
	
	private String country;
	
	private String town;
	
	private boolean gender;
	
	private String food;
	
	
	public UserSignUpForm() {}


	public UserSignUpForm(String userName, String password, String nume, String prenume, String email, String phone,
			String country, String town, boolean gender, String food) {
		super();
		this.userName = userName;
		this.password = password;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.town = town;
		this.gender = gender;
		this.food = food;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSignUpForm other = (UserSignUpForm) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
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


	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	public String getPrenume() {
		return prenume;
	}


	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getTown() {
		return town;
	}


	public void setTown(String town) {
		this.town = town;
	}


	public boolean isGender() {
		return gender;
	}


	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public String getFood() {
		return food;
	}


	public void setFood(String food) {
		this.food = food;
	}
	
	
}
