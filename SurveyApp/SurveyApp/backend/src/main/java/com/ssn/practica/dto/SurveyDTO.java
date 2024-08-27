package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ssn.practica.model.Question;
import com.ssn.practica.model.Survey;

public class SurveyDTO extends SurveyTemplateDTO {

	private List<QuestionDTO> questionDTOs = new ArrayList<QuestionDTO>();

	public SurveyDTO() {
		super();
	}

	public List<QuestionDTO> getQuestionDTOs() {
		return questionDTOs;
	}

	public void setQuestionDTOs(List<QuestionDTO> questionDTOs) {
		this.questionDTOs = questionDTOs;
	}

	public static SurveyDTO fromSurvey(Survey survey) {
		SurveyDTO surveyDTO = new SurveyDTO();
		surveyDTO.setCountriesDTO(
				survey.getCountries().stream().map(CountryDTO::fromCountry).collect(Collectors.toList()));

		surveyDTO.setCitiesDTO(survey.getCities().stream().map(CityDTO::fromCity).collect(Collectors.toList()));
		surveyDTO.setCreationDate(survey.getCreationDate());
		surveyDTO.setDescription(survey.getDescription());
		surveyDTO.setDueDate(survey.getDueDate());
		surveyDTO.setPrice(survey.getPrice());
		surveyDTO.setSurveyId(survey.getSurveyId());
		surveyDTO.setTitle(survey.getTitle());
		surveyDTO.setUserUsername(survey.getUser().getUsername());

		for (Question question : survey.getQuestions()) {
			surveyDTO.getQuestionDTOs().add(QuestionDTO.fromQuestion(question));
		}

		return surveyDTO;
	}

	public static Survey fromSurveyDTO(SurveyDTO surveyDTO) {

		Survey survey = new Survey();
		survey.setCountries(
				surveyDTO.getCountriesDTO().stream().map(CountryDTO::fromCountryDTO).collect(Collectors.toList()));

		survey.setCities(surveyDTO.getCitiesDTO().stream().map(CityDTO::fromCityDTO).collect(Collectors.toList()));
		survey.setCreationDate(surveyDTO.getCreationDate());
		survey.setDescription(surveyDTO.getDescription());
		survey.setDueDate(surveyDTO.getDueDate());
		survey.setPrice(surveyDTO.getPrice());
		survey.setSurveyId(surveyDTO.getSurveyId());
		survey.setTitle(surveyDTO.getTitle());
		survey.setUserUsername(surveyDTO.getUserUsername());

		for (QuestionDTO questionDTO : surveyDTO.getQuestionDTOs()) {
			survey.getQuestions().add(QuestionDTO.fromQuestionDTO(questionDTO));
		}

		return survey;

	}

}
