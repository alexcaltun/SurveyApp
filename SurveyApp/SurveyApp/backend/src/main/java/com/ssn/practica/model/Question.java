package com.ssn.practica.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Question extends QuestionTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "answer_id")
	private Answer answer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "survey_id", nullable = true)
	private Survey survey;

	public Question() {
		super();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

//	@Override
//	public String toString() {
//		return "Question [id=" + id + ", questionId=" + questionId + ", question=" + question + ", answer=" + answer
//				+ ", answers=" + options + "]";
//	}

}
