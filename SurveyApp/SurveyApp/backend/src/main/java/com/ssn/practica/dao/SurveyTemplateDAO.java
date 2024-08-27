package com.ssn.practica.dao;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.SurveyTemplate;

public class SurveyTemplateDAO {
	public void addSurveyTemplate(SurveyTemplate surveyTemplate) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(surveyTemplate);
			}

		}.run();
	}

	public void deleteSurveyTemplate(String surveyId) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				SurveyTemplate surveyTemplate = session.get(SurveyTemplate.class, surveyId);
				if (surveyTemplate != null) {
					session.delete(surveyTemplate);
				}
			}
		}.run();
	}

	public void updateSurveyTemplate(SurveyTemplate surveyTemplate) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(surveyTemplate);
			}
		}.run();
	}

	public SurveyTemplate getSurveyTemplateBySurveyId(String surveyId) {
		return new WithSessionAndTransaction<SurveyTemplate>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				SurveyTemplate surveyTemplate = session
						.createQuery("SELECT s FROM SurveyTemplate s WHERE s.surveyId = :surveyId",
								SurveyTemplate.class)
						.setParameter("surveyId", surveyId).uniqueResult();
				setReturnValue(surveyTemplate);
			}
		}.run();
	}
}
