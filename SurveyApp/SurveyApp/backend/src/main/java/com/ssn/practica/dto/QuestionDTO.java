package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Question;

public class QuestionDTO {
	private Long id;
	private String questionId;
	private String question;
	private Answer answer;
	private List<AnswerDTO> answerDTOs = new ArrayList<AnswerDTO>();
	private String surveyId;

	public QuestionDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<AnswerDTO> getAnswerDTOs() {
		return answerDTOs;
	}

	public void setAnswerDTOs(List<AnswerDTO> answerDTOs) {
		this.answerDTOs = answerDTOs;
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	public static QuestionDTO fromQuestion(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();

		questionDTO.setId(question.getId());
		questionDTO.setQuestionId(question.getQuestionId());
		questionDTO.setQuestion(question.getQuestion());
		questionDTO.setAnswer(question.getAnswer());
		questionDTO.setSurveyId(question.getSurvey().getSurveyId());

		for (Answer answer : question.getAnswers()) {
			questionDTO.getAnswerDTOs().add(AnswerDTO.fromAnswer(answer));
		}

		return questionDTO;
	}

	public static Question fromQuestionDTO(QuestionDTO questionDTO) {
		Question question = new Question();

		return question;
	}

}
