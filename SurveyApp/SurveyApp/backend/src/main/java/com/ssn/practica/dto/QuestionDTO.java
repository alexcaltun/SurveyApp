package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Question;

public class QuestionDTO {
	private String questionId;
	private String question;
	private Answer answer;
	private List<String> options = new ArrayList<String>();
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
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
		questionDTO.setQuestion(question.getQuestion());
		questionDTO.setAnswer(question.getAnswer());
		questionDTO.setSurveyId(question.getSurvey().getSurveyId());
		questionDTO.setOptions(question.getOptions());

		return questionDTO;
	}

	public static Question fromQuestionDTO(QuestionDTO questionDTO) {
		Question question = new Question();

		question.setQuestionId(questionDTO.getQuestionId());
		question.setQuestion(questionDTO.getQuestion());
		question.setAnswer(questionDTO.getAnswer());
		question.setOptions(questionDTO.getOptions());

		// SurveyDAO surveyDAO = new SurveyDAO();
		// Survey survey = surveyDTO.getSurveyBySurveyId(questionDTO.getSurveyId());

		// question.setSurvey(survey);

		return question;
	}

}
