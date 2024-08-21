package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ssn.practica.model.Question;
import com.ssn.practica.model.Survey;
import com.ssn.practica.model.User;

public class SurveyDTO {

	private String surveyId;
	private String title;
	private String description;
	private String userUsername;
	private Date creationDate;
	private Date dueDate;
	private double price;
	
	private List<String> countries = new ArrayList<String>();
	private List<String> cities = new ArrayList<String>();
	
	private List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();
	
	public SurveyDTO() {
		super();
	}
	
	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
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

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
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

	public List<QuestionDTO> getQuestionDTOs() {
		return questionDTOs;
	}

	public void setQuestionDTOs(List<QuestionDTO> questionDTOs) {
		this.questionDTOs = questionDTOs;
	}

	public static SurveyDTO fromSurvey(Survey survey) {
		SurveyDTO surveyDTO = new SurveyDTO();
		surveyDTO.setCities(survey.getCities());
		surveyDTO.setCountries(survey.getCountries());
		surveyDTO.setCreationDate(survey.getCreationDate());
		surveyDTO.setDescription(survey.getDescription());
		surveyDTO.setDueDate(survey.getDueDate());
		surveyDTO.setPrice(survey.getPrice());
		surveyDTO.setSurveyId(survey.getSurveyId());
		surveyDTO.setTitle(survey.getTitle());
		surveyDTO.setUserUsername(survey.getUser().getUsername());
		
		for(Question question: survey.getQuestions())
			surveyDTO.getQuestionDTOs().add(QuestionDTO.fromQuestion(question));

		return surveyDTO;
	}

	public static Survey fromSurveyDTO(SurveyDTO surveyDTO) {
		
		Survey survey = new Survey();
		survey.setCities(surveyDTO.getCities());
		survey.setCountries(surveyDTO.getCountries());
		survey.setCreationDate(surveyDTO.getCreationDate());
		survey.setDescription(surveyDTO.getDescription());
		survey.setDueDate(surveyDTO.getDueDate());
		survey.setPrice(surveyDTO.getPrice());
		survey.setSurveyId(surveyDTO.getSurveyId());
		survey.setTitle(surveyDTO.getTitle());
		survey.setUserUsername(surveyDTO.getUserUsername());
		
		for(QuestionDTO questionDTO: surveyDTO.getQuestionDTOs())
			survey.getQuestions().add(QuestionDTO.fromQuestionDTO(questionDTO));

		return survey;
		
	}

}
