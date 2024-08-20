package com.ssn.practica.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	// @Column(nullable = false)
	private String answerId;

	// @Column(nullable = false)
	private String answer;

	// @Column(nullable = false)
	private Date date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id", nullable = true)
	private Question question;

	public Answer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date answerDate) {
		this.date = answerDate;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answerId=" + answerId + ", answer=" + answer + ", answerDate=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(answerId);
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
		Answer other = (Answer) obj;
		return Objects.equals(answerId, other.answerId);
	}

}
