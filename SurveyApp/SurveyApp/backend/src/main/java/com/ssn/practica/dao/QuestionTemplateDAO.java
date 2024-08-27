package com.ssn.practica.dao;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.QuestionTemplate;

public class QuestionTemplateDAO {
	public void addQuestionTemplate(QuestionTemplate questionTemplate) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(questionTemplate);
			}

		}.run();
	}

	public void deleteQuestionTemplate(String questionId) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				QuestionTemplate questionTemplate = session.get(QuestionTemplate.class, questionId);
				if (questionTemplate != null) {
					session.delete(questionTemplate);
				}
			}
		}.run();
	}

	public void updateQuestionTemplate(QuestionTemplate questionTemplate) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(questionTemplate);
			}
		}.run();
	}

	public QuestionTemplate getQuestionTemplateByQuestionId(String questionId) {
		return new WithSessionAndTransaction<QuestionTemplate>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				QuestionTemplate questionTemplate = session
						.createQuery("SELECT q FROM QuestionTemplate q WHERE q.questionId = :questionId",
								QuestionTemplate.class)
						.setParameter("questionId", questionId).uniqueResult();
				setReturnValue(questionTemplate);
			}
		}.run();
	}
}
