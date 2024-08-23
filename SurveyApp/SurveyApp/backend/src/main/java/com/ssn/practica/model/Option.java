package com.ssn.practica.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MY_OPTION")
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String optionId;
	private String text;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionTemplate_id", nullable = true)
	private QuestionTemplate questionTemplate;

	public Option() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public QuestionTemplate getQuestionTemplate() {
		return questionTemplate;
	}

	public void setQuestionTemplate(QuestionTemplate questionTemplate) {
		this.questionTemplate = questionTemplate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(optionId);
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
		Option other = (Option) obj;
		return Objects.equals(optionId, other.optionId);
	}
}
