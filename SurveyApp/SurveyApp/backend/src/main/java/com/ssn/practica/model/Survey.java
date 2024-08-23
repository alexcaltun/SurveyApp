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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Survey extends SurveyTemplate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true)
	private User surveyUser;

	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
	private List<Question> questions = new ArrayList<Question>();

	public Survey() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public Date getDueDate() {
		return dueDate;
	}

	@Override
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public List<String> getCountries() {
		return countries;
	}

	@Override
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	@Override
	public List<String> getCities() {
		return cities;
	}

	@Override
	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public User getUser() {
		return surveyUser;
	}

	public void setUser(User surveyUser) {
		this.surveyUser = surveyUser;
	}

	@Override
	public String getSurveyId() {
		return surveyId;
	}

	@Override
	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", surveyId=" + surveyId + ", title=" + title + ", description=" + description
				+ ", creationDate=" + creationDate + ", dueDate=" + dueDate + ", price=" + price + ", countries="
				+ countries + ", cities=" + cities + ", questions=" + questions + "]";
	}

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
		Survey other = (Survey) obj;
		return Objects.equals(surveyId, other.surveyId);
	}

}
