package com.ssn.practica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	// @Column(nullable = false)
	private String questionId;

	// @Column(nullable = false)
	private String question;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "answer_id", referencedColumnName = "id")
	private Answer answer;

	@ElementCollection
	@CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
	@Column(name = "option_value")
	private List<String> options = new ArrayList<String>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "survey_id", nullable = true)
	private Survey survey;

	public Question() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public int hashCode() {
		return Objects.hash(questionId);
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
		Question other = (Question) obj;
		return Objects.equals(questionId, other.questionId);
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionId=" + questionId + ", question=" + question + ", answer=" + answer
				+ ", answers=" + options + "]";
	}

}
