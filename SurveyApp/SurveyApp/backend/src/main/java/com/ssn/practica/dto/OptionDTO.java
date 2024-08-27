package com.ssn.practica.dto;

import com.ssn.practica.dao.QuestionTemplateDAO;
import com.ssn.practica.model.Option;
import com.ssn.practica.model.QuestionTemplate;

public class OptionDTO {
	private String optionID;
	private String text;
	private String questionTemplateId;

	public OptionDTO() {
		super();
	}

	public String getOptionID() {
		return optionID;
	}

	public void setOptionID(String optionID) {
		this.optionID = optionID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getQuestionTemplateId() {
		return questionTemplateId;
	}

	public void setQuestionTemplateId(String questionTemplateId) {
		this.questionTemplateId = questionTemplateId;
	}

	public static OptionDTO fromOption(Option option) {
		OptionDTO optionDTO = new OptionDTO();

		optionDTO.setOptionID(option.getOptionId());
		optionDTO.setText(option.getText());
		optionDTO.setQuestionTemplateId(option.getQuestionTemplate().getQuestionId());

		return optionDTO;
	}

	public static Option fromOptionDTO(OptionDTO optionDTO) {
		Option option = new Option();

		option.setOptionId(optionDTO.getOptionID());
		option.setText(optionDTO.getText());

		QuestionTemplateDAO questionTemplateDAO = new QuestionTemplateDAO();
		QuestionTemplate questionTemplate = questionTemplateDAO
				.getQuestionTemplateByQuestionId(optionDTO.getQuestionTemplateId());

		option.setQuestionTemplate(questionTemplate);

		return option;
	}
}
