package com.ssn.practica.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Answer;

public class AnswerDAO {
	public void addAnswer(Answer answer) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(answer);
			}

		}.run();
	}

	public void deleteAnswer(String answerId) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Answer answer = session.get(Answer.class, answerId);
				if (answer != null) {
					session.delete(answer);
				}
			}
		}.run();
	}

	public void updateAnswer(Answer answer) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(answer);
			}
		}.run();
	}

	public Answer getAnswerByAnswerId(String answerId) {
		return new WithSessionAndTransaction<Answer>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				Answer answer = session.createQuery("SELECT a FROM Answer a WHERE a.answerId = :answerId", Answer.class)
						.setParameter("answerId", answerId).getSingleResult();
				setReturnValue(answer);
			}
		}.run();
	}

	public List<Answer> getAnswersByQuestionId(String questionId) {
		return new WithSessionAndTransaction<List<Answer>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<Answer> answers = session
						.createQuery("SELECT a FROM Answer a WHERE a.question.questionId = :questionId", Answer.class)
						.setParameter("questionId", questionId).getResultList();
				setReturnValue(answers);
			}
		}.run();
	}

	public List<Answer> getAnswersByDate(Date date) {
		return new WithSessionAndTransaction<List<Answer>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<Answer> answers = session.createQuery("SELECT a FROM Answer a WHERE a.date = :date", Answer.class)
						.setParameter("date", date).getResultList();
				setReturnValue(answers);
			}
		}.run();
	}
}
