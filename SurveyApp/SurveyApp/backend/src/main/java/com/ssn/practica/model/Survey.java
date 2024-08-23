package com.ssn.practica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@Enumerated(EnumType.STRING)
	private State state;

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public User getSurveyUser() {
		return surveyUser;
	}

	public void setSurveyUser(User surveyUser) {
		this.surveyUser = surveyUser;
	}

	public User getUser() {
		return surveyUser;
	}

	public void setUser(User surveyUser) {
		this.surveyUser = surveyUser;
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
