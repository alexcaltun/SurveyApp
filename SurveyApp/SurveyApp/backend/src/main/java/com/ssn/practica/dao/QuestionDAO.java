package com.ssn.practica.dao;

import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Question;

public class QuestionDAO {
	public void addQuestion(Question question) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(question);
			}

		}.run();
	}

	public void deteleQuestion(String id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Question question = session.get(Question.class, id);
				if (question != null) {
					session.delete(question);
				}
			}
		}.run();
	}

	public void updateQuestion(Question question) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(question);
			}
		}.run();
	}

	public Question getQuestionByQuestionId(String questionId) {
		return new WithSessionAndTransaction<Question>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Question question = session
						.createQuery("SELECT q FROM Question q WHERE q.questionId = :questionId", Question.class)
						.setParameter("questionId", questionId).uniqueResult();
				setReturnValue(question);
			}
		}.run();
	}

	public List<Question> getQuestionsBySurveyId(String surveyId) {
		return new WithSessionAndTransaction<List<Question>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<Question> questions = session
						.createQuery("SELECT q FROM Question q WHERE q.survey.surveyId = :surveyId", Question.class)
						.setParameter("surveyId", surveyId).getResultList();
				setReturnValue(questions);
			}
		}.run();
	}
}
