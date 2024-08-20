package com.ssn.practica.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	@Column(nullable = false)
	private String answerId;

	@Column(nullable = false)
	private String answer;

	@Column(nullable = false)
	private Date answerDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id", nullable = true)
	private Task task;

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
		return answerDate;
	}

	public void setDate(Date answerDate) {
		this.answerDate = answerDate;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", answerId=" + answerId + ", answer=" + answer + ", date=" + answerDate
				+ "taskId= " + task.getTaskId() + "]";
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
