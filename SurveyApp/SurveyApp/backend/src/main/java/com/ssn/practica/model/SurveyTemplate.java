package com.ssn.practica.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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

	@ElementCollection
	@CollectionTable(name = "survey_countries", joinColumns = @JoinColumn(name = "survey_id"))
	@Column(name = "country")
	protected List<String> countries = new ArrayList<String>();

	@ElementCollection
	@CollectionTable(name = "survey_cities", joinColumns = @JoinColumn(name = "survey_id"))
	@Column(name = "city")
	protected List<String> cities = new ArrayList<String>();

	// private Map<String, String> questionAnswer = new HashMap<String, String>();

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

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

//	public Map<String, String> getQuestionAnswer() {
//		return questionAnswer;
//	}
//
//	public void setQuestionAnswer(Map<String, String> questionAnswer) {
//		this.questionAnswer = questionAnswer;
//	}

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
