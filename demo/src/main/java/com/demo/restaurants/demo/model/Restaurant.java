package com.demo.restaurants.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String adress;
	
	@NotNull
	private Double rating;
	
	private String site;
	
	@NotNull
	private Integer numberReviews;
	
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	private Set<UserReview> userReview = new HashSet<>();
	
	public Restaurant() {}

	public Restaurant(@NotEmpty Long id, @NotEmpty String name, @NotEmpty String adress, @NotEmpty Double rating,
			String site, @NotEmpty Integer numberReviews) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.rating = rating;
		this.site = site;
		this.numberReviews = numberReviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberReviews == null) ? 0 : numberReviews.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberReviews == null) {
			if (other.numberReviews != null)
				return false;
		} else if (!numberReviews.equals(other.numberReviews))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getNumberReviews() {
		return numberReviews;
	}

	public void setNumberReviews(Integer numberReviews) {
		this.numberReviews = numberReviews;
	}

	public Set<UserReview> getUserReview() {
		return userReview;
	}

	public void setUserReview(Set<UserReview> userReview) {
		this.userReview = userReview;
	}
	
}
