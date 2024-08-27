package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssn.practica.dao.SurveyTemplateDAO;
import com.ssn.practica.model.Option;
import com.ssn.practica.model.QuestionTemplate;

public class QuestionTemplateDTO {

	protected String questionId;
	protected String text;

	private String surveyTemplateId;

	protected List<OptionDTO> optionsDTO = new ArrayList<OptionDTO>();

	public QuestionTemplateDTO() {
		super();
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

	public String getSurveyTemplateId() {
		return surveyTemplateId;
	}

	public void setSurveyTemplateId(String surveyTemplateId) {
		this.surveyTemplateId = surveyTemplateId;
	}

	public List<OptionDTO> getOptionsDTO() {
		return optionsDTO;
	}

	public void setOptionsDTO(List<OptionDTO> optionsDTO) {
		this.optionsDTO = optionsDTO;
	}

	public static QuestionTemplateDTO fromQuestionTemplate(QuestionTemplate questionTemplate) {

		QuestionTemplateDTO questionTemplateDTO = new QuestionTemplateDTO();

		questionTemplateDTO.setQuestionId(questionTemplate.getQuestionId());
		questionTemplateDTO.setText(questionTemplate.getText());
		questionTemplateDTO.setSurveyTemplateId(questionTemplate.getSurveyTemplate().getSurveyId());
		for (Option option : questionTemplate.getOptions()) {
			questionTemplateDTO.getOptionsDTO().add(OptionDTO.fromOption(option));
		}

		return questionTemplateDTO;
	}

	public static QuestionTemplate fromQuestionTemplateDTO(QuestionTemplateDTO questionTemplateDTO) {

		QuestionTemplate questionTemplate = new QuestionTemplate();
		SurveyTemplateDAO surveyTemplateDAO = new SurveyTemplateDAO();

		questionTemplate.setQuestionId(questionTemplateDTO.getQuestionId());
		questionTemplate.setText(questionTemplateDTO.getText());
		questionTemplate.setSurveyTemplate(
				surveyTemplateDAO.getSurveyTemplateBySurveyId(questionTemplateDTO.getSurveyTemplateId()));
		for (OptionDTO optionDTO : questionTemplateDTO.getOptionsDTO()) {
			questionTemplate.getOptions().add(OptionDTO.fromOptionDTO(optionDTO));
		}

		return questionTemplate;
	}

}
