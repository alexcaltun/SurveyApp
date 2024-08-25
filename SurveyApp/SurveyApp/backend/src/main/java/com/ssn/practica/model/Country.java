package com.ssn.practica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	@OneToOne(mappedBy = "country")
	private User countryUser;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<City> cities = new ArrayList<City>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "surveyTemplate_id", nullable = true)
	private SurveyTemplate surveyTemplate;

	public Country() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
	}

	public void setSurveyTemplate(SurveyTemplate surveyTemplate) {
		this.surveyTemplate = surveyTemplate;
	}

}
