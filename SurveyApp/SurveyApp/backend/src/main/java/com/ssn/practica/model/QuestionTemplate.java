package com.ssn.practica.model;

import java.util.ArrayList;
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
public class QuestionTemplate {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	protected String questionId;
	protected String text;

	@OneToMany(mappedBy = "questionTemplate", cascade = CascadeType.ALL)
	protected List<Option> options = new ArrayList<Option>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "surveyTemplate_id", nullable = true)
	private SurveyTemplate surveyTemplate;

	public QuestionTemplate() {
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public SurveyTemplate getSurveyTemplate() {
		return surveyTemplate;
	}

	public void setSurveyTemplate(SurveyTemplate surveyTemplate) {
		this.surveyTemplate = surveyTemplate;
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
		QuestionTemplate other = (QuestionTemplate) obj;
		return Objects.equals(questionId, other.questionId);
	}
}
