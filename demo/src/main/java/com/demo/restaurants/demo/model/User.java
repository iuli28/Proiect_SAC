package com.demo.restaurants.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.JoinColumn;


@Entity
@Table(name = "users")
@Transactional
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
	
	private String food;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<UserReview> userReview = new HashSet<>();

	public User() {}
	
	public User(Long id, @NotEmpty String userName, @NotEmpty String password, Roles role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;

	}

	public User(@NotEmpty String userName, @NotEmpty String password, @NotEmpty String nume,
			@NotEmpty String prenume, @NotEmpty String email, @NotEmpty String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.nume = nume;
		this.prenume = prenume;
		this.email = email;
		this.phone = phone;

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
		this.food = food;
		this.userReview = userReview;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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


	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}
	
	public void addUserReview(UserReview urReview) {
		this.userReview.add(urReview);
	}
}
