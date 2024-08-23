package com.ssn.practica.dto;

import com.ssn.practica.dao.QuestionDAO;
import com.ssn.practica.model.Answer;
import com.ssn.practica.model.Question;

public class AnswerDTO {
	private String answerId;
	private String answer;
	private String questionId;

	public AnswerDTO() {
		super();
	}

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public static AnswerDTO fromAnswer(Answer answer) {
		AnswerDTO answerDTO = new AnswerDTO();

		answerDTO.setAnswerId(answer.getAnswerId());
		answerDTO.setAnswer(answer.getAnswer());
		answerDTO.setQuestionId(answer.getQuestion().getQuestionId());

		return answerDTO;
	}

	public static Answer fromAnswerDTO(AnswerDTO answerDTO) {
		Answer answer = new Answer();

		answer.setAnswerId(answerDTO.getAnswerId());
		answer.setAnswer(answerDTO.getAnswer());

		QuestionDAO questionDAO = new QuestionDAO();
		Question question = questionDAO.getQuestionByQuestionId(answerDTO.getQuestionId());

		answer.setQuestion(question);

		return answer;
	}

}
