package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssn.practica.dao.SurveyDAO;
import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Option;
import com.ssn.practica.model.Question;
import com.ssn.practica.model.Survey;

public class QuestionDTO {
	private String questionId;
	private String text;
	private Answer answer;
	private List<Option> options = new ArrayList<Option>();
	private String surveyId;

	public QuestionDTO() {
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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public static QuestionDTO fromQuestion(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();

		questionDTO.setQuestionId(question.getQuestionId());
		questionDTO.setText(question.getText());
		questionDTO.setAnswer(question.getAnswer());
		questionDTO.setSurveyId(question.getSurvey().getSurveyId());
		questionDTO.setOptions(question.getOptions());

		return questionDTO;
	}

	public static Question fromQuestionDTO(QuestionDTO questionDTO) {
		Question question = new Question();

		question.setQuestionId(questionDTO.getQuestionId());
		question.setText(questionDTO.getText());
		question.setAnswer(questionDTO.getAnswer());
		question.setOptions(questionDTO.getOptions());

		SurveyDAO surveyDAO = new SurveyDAO();
		Survey survey = surveyDAO.getSurveyBySurveyId(questionDTO.getSurveyId());

		question.setSurvey(survey);

		return question;
	}

}
