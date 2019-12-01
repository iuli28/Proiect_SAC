package com.demo.restaurants.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	private Long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String adress;
	
	@NotEmpty
	private Double rating;
	
	private String site;
	
	@NotEmpty
	private Integer numberReviews;
	
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

}
