package com.demo.restaurants.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String nume;
	
	@NotEmpty
	private String prenume;
	
	@NotEmpty
	private String email;

	private String phone;
	
	private String country;
	
	private String town;
	
	private boolean gender;
	
	private String food;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserReview> userReview = new HashSet<>();

	public User() {}
	
	public User(Long id, @NotEmpty String userName, @NotEmpty String password, Roles role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public User(Long id, @NotEmpty String userName, @NotEmpty String password, @NotEmpty String nume,
			@NotEmpty String prenume, @NotEmpty String email, @NotEmpty String phone, Roles role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.phone = phone;
		this.role = role;
	}
	
	

	public User(Long id, @NotEmpty String userName, @NotEmpty String password, @NotEmpty String nume,
			@NotEmpty String prenume, @NotEmpty String email, @NotEmpty String phone, String country, String town,
			boolean gender, String food, Roles role, Set<UserReview> userReview) {
		super();
		this.id = id;
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
		this.role = role;
		this.userReview = userReview;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((prenume == null) ? 0 : prenume.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (prenume == null) {
			if (other.prenume != null)
				return false;
		} else if (!prenume.equals(other.prenume))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
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

	public Set<UserReview> getUserReview() {
		return userReview;
	}

	public void setUserReview(Set<UserReview> userReview) {
		this.userReview = userReview;
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
