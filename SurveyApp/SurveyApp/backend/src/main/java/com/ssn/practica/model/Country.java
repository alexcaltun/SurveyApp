package com.ssn.practica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true)
	private User countryUser;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<City> cities = new ArrayList<City>();

	public Country() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCountryUser() {
		return countryUser;
	}

	public void setCountryUser(User countryUser) {
		this.countryUser = countryUser;
	}

}
