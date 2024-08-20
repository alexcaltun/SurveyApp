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
public class Survey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String id;
	private String surveyId;
	private String title;
	private String description;
	private Date creationDate;
	private Date dueDate;
	private double price;
	
	private List<String> countries = new ArrayList<String>();
	private List<String> cities = new ArrayList<String>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", nullable = true)
	private User user;

	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Question> questions = new ArrayList<Question>();
	
	public Survey() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public String getSurveyId() {
		return surveyId;
	}

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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		return Objects.equals(surveyId, other.surveyId);
	}
	
}
