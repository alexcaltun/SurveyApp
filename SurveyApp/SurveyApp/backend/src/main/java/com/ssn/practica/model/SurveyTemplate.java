package com.ssn.practica.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SurveyTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	protected String surveyId;
	protected String title;
	protected String description;
	protected String userUsername;
	protected Date creationDate;
	protected Date dueDate;
	protected double price;

	@OneToMany(mappedBy = "surveyTemplate", cascade = CascadeType.ALL)
	protected List<Country> countries = new ArrayList<Country>();

	@OneToMany(mappedBy = "surveyTemplate", cascade = CascadeType.ALL)
	protected List<City> cities = new ArrayList<City>();

	@OneToMany(mappedBy = "surveyTemplate", cascade = CascadeType.ALL)
	private List<QuestionTemplate> questions = new ArrayList<QuestionTemplate>();

	public SurveyTemplate() {
		super();
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

//	@Override
//	public String toString() {
//		return "SurveyTemplate [surveyId=" + surveyId + ", title=" + title + ", questionAnswer=" + questionAnswer + "]";
//	}

	@Override
	public int hashCode() {
		return Objects.hash(surveyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SurveyTemplate other = (SurveyTemplate) obj;
		return Objects.equals(surveyId, other.surveyId);
	}

}
