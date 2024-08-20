package com.ssn.practica.dto;

import java.util.Date;

import com.ssn.practica.dao.TaskDAO;
import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Task;

public class AnswerDTO {

	private Long id;
	private String answer;
	private Date date;
	private String taskTaskId;

	public AnswerDTO() {
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

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTaskTaskId() {
		return taskTaskId;
	}

	public void setTaskTaskId(String taskTaskId) {
		this.taskTaskId = taskTaskId;
	}

	public static AnswerDTO fromAnswer(Answer answer) {
		AnswerDTO answerDTO = new AnswerDTO();

		answerDTO.setAnswer(answer.getAnswer());
		answerDTO.setId(answer.getId());
		answerDTO.setDate(answer.getDate());
		answerDTO.setTaskTaskId(answer.getTask().getTaskId());
		return answerDTO;
	}

	public static Answer fromAnswerDTO(AnswerDTO answerDTO) {
		Answer answer = new Answer();

		answer.setAnswer(answerDTO.getAnswer());
		answer.setId(answerDTO.getId());
		answer.setDate(answerDTO.getDate());

		TaskDAO taskDAO = new TaskDAO();
		Task task = taskDAO.getTaskByTaskId(answerDTO.getTaskTaskId());

		answer.setTask(task);
		return answer;
	}

}
