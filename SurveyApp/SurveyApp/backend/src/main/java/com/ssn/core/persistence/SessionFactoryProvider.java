/*
 * Copyright (c) 2014 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.ssn.core.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ssn.practica.model.Answer;
import com.ssn.practica.model.City;
import com.ssn.practica.model.Country;
import com.ssn.practica.model.Option;
import com.ssn.practica.model.Question;
import com.ssn.practica.model.QuestionTemplate;
import com.ssn.practica.model.State;
import com.ssn.practica.model.Survey;
import com.ssn.practica.model.SurveyTemplate;
import com.ssn.practica.model.User;

public class SessionFactoryProvider {

	public static void main(String[] args) {
		SessionFactoryProvider.init();
	}

	private static SessionFactory factory;

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			try {
				Configuration configuration = new Configuration().configure();
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties());
				factory = configuration.buildSessionFactory(builder.build());

				factory = new Configuration().configure("hibernate.cfg.xml") //
						.addAnnotatedClass(Question.class) //
						.addAnnotatedClass(User.class) //
						.addAnnotatedClass(Survey.class) //
						.addAnnotatedClass(SurveyTemplate.class) //
						.addAnnotatedClass(QuestionTemplate.class) //
						.addAnnotatedClass(City.class) //
						.addAnnotatedClass(Country.class) //
						.addAnnotatedClass(Option.class) //
						.addAnnotatedClass(State.class) //
						.addAnnotatedClass(Answer.class) //
						.buildSessionFactory();
				// init();
			} catch (Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
			}
		}
		{
		}

		return factory;
	}

	private static void init() {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				Answer answer = new Answer();
				// answer.setAnswer("cevaa");
				answer.setAnswerId("123");

				session.save(answer);

			}

		}.run();
	}
}
