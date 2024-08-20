package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Task;
import com.ssn.practica.model.TaskState;

public class TaskDTO {
	private Long id;
	private String taskId;
	private String country;
	private String city;
	private String zone;
	private String description;
	private Date dueDate;
	private double price;
	private TaskState state;
	private List<AnswerDTO> answersDTO;

	public TaskDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public TaskState getState() {
		return state;
	}

	public void setState(TaskState state) {
		this.state = state;
	}

	public List<AnswerDTO> getAnswersDTO() {
		return answersDTO;
	}

	public void setAnswersDTO(List<AnswerDTO> answersDTO) {
		this.answersDTO = answersDTO;
	}

	public static TaskDTO fromTask(Task task) {
		TaskDTO taskDTO = new TaskDTO();

		taskDTO.setId(task.getId());
		taskDTO.setCountry(task.getCountry());
		taskDTO.setCity(task.getCity());
		taskDTO.setZone(task.getZone());
		taskDTO.setDescription(task.getDescription());
		taskDTO.setDueDate(task.getDueDate());
		taskDTO.setPrice(task.getPrice());
		taskDTO.setState(task.getState());

		for (Answer answer : task.getAnswers()) {
			taskDTO.getAnswersDTO().add(AnswerDTO.fromAnswer(answer));
		}

		return taskDTO;
	}

	public static Task fromTaskDTO(TaskDTO taskDTO) {
		Task task = new Task();

		task.setId(taskDTO.getId());
		task.setCountry(taskDTO.getCountry());
		task.setCity(taskDTO.getCity());
		task.setZone(taskDTO.getZone());
		task.setDescription(taskDTO.getDescription());
		task.setDueDate(taskDTO.getDueDate());
		task.setPrice(taskDTO.getPrice());
		task.setState(taskDTO.getState());

		List<Answer> answers = new ArrayList<Answer>();

		for (AnswerDTO answerDTO : taskDTO.getAnswersDTO()) {
			answers.add(AnswerDTO.fromAnswerDTO(answerDTO));
		}

		task.setAnswers(answers);

		return task;
	}
}
