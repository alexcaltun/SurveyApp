package com.ssn.practica.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Survey;

public class SurveyDAO {
	public void addSurvey(Survey survey) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(survey);
			}

		}.run();
	}

	public void deleteSurvey(String id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Survey survey = session.get(Survey.class, id);
				if (survey != null) {
					session.delete(survey);
				}
			}
		}.run();
	}

	public void updateSurvey(Survey survey) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(survey);
			}
		}.run();
	}

	public Survey getSurveyBySurveyId(String surveyId) {
		return new WithSessionAndTransaction<Survey>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Survey survey = session.createQuery("SELECT s FROM Survey s WHERE s.surveyId = :surveyId", Survey.class)
						.setParameter("surveyId", surveyId).uniqueResult();
				setReturnValue(survey);
			}
		}.run();
	}

	public List<Survey> getSurveysByDueDate(Date dueDate) {
		return new WithSessionAndTransaction<List<Survey>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<Survey> surveys = session
						.createQuery("SELECT s FROM Survey s WHERE s.dueDate = :dueDate", Survey.class)
						.setParameter("dueDate", dueDate).getResultList();
				setReturnValue(surveys);
			}
		}.run();
	}
}
