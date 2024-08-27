package com.ssn.practica.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ssn.practica.model.SurveyTemplate;

public class SurveyTemplateDTO {

	private String surveyId;
	private String title;
	private String description;
	private String userUsername;

	private Date creationDate;
	private Date dueDate;

	private double price;

	private List<CountryDTO> countriesDTO;
	private List<CityDTO> citiesDTO;
	private List<QuestionTemplateDTO> questionsDTO;

	public SurveyTemplateDTO() {
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

	public List<CountryDTO> getCountriesDTO() {
		return countriesDTO;
	}

	public void setCountriesDTO(List<CountryDTO> countriesDTO) {
		this.countriesDTO = countriesDTO;
	}

	public List<CityDTO> getCitiesDTO() {
		return citiesDTO;
	}

	public void setCitiesDTO(List<CityDTO> citiesDTO) {
		this.citiesDTO = citiesDTO;
	}

	public List<QuestionTemplateDTO> getQuestionsDTO() {
		return questionsDTO;
	}

	public void setQuestionsDTO(List<QuestionTemplateDTO> questionsDTO) {
		this.questionsDTO = questionsDTO;
	}

	public static SurveyTemplateDTO SurveyTemplate(SurveyTemplate surveyTemplate) {
		SurveyTemplateDTO dto = new SurveyTemplateDTO();
		dto.setSurveyId(surveyTemplate.getSurveyId());
		dto.setTitle(surveyTemplate.getTitle());
		dto.setDescription(surveyTemplate.getDescription());
		dto.setUserUsername(surveyTemplate.getUserUsername());
		dto.setCreationDate(surveyTemplate.getCreationDate());
		dto.setDueDate(surveyTemplate.getDueDate());
		dto.setPrice(surveyTemplate.getPrice());

		dto.setCountriesDTO(
				surveyTemplate.getCountries().stream().map(CountryDTO::fromCountry).collect(Collectors.toList()));

		dto.setCitiesDTO(surveyTemplate.getCities().stream().map(CityDTO::fromCity).collect(Collectors.toList()));

		dto.setQuestionsDTO(surveyTemplate.getQuestionsTemplate().stream()
				.map(QuestionTemplateDTO::fromQuestionTemplate).collect(Collectors.toList()));

		return dto;
	}

	public static SurveyTemplate SurveyTemplateDTO(SurveyTemplateDTO dto) {
		SurveyTemplate surveyTemplate = new SurveyTemplate();
		surveyTemplate.setSurveyId(dto.getSurveyId());
		surveyTemplate.setTitle(dto.getTitle());
		surveyTemplate.setDescription(dto.getDescription());
		surveyTemplate.setUserUsername(dto.getUserUsername());
		surveyTemplate.setCreationDate(dto.getCreationDate());
		surveyTemplate.setDueDate(dto.getDueDate());
		surveyTemplate.setPrice(dto.getPrice());

		surveyTemplate.setCountries(
				dto.getCountriesDTO().stream().map(CountryDTO::fromCountryDTO).collect(Collectors.toList()));

		surveyTemplate.setCities(dto.getCitiesDTO().stream().map(CityDTO::fromCityDTO).collect(Collectors.toList()));

		surveyTemplate.setQuestionsTemplate(dto.getQuestionsDTO().stream()
				.map(QuestionTemplateDTO::fromQuestionTemplateDTO).collect(Collectors.toList()));

		return surveyTemplate;
	}

}
