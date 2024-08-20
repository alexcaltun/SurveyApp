/*
 * Copyright (c) 2014 SSI Schaefer Noell GmbH
 *
 * $Header: $
 */

package com.ssn.core.persistence;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ssn.practica.model.Answer;
//import com.ssn.practica.model.OrderState;
import com.ssn.practica.model.Task;
import com.ssn.practica.model.TaskState;

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
						.addAnnotatedClass(Task.class) //
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
				answer.setAnswer("cevaa");
				answer.setAnswerId("123");
				answer.setDate(Calendar.getInstance().getTime());

				session.save(answer);

				Task task = new Task();
				task.setTaskId("333");
				task.setCountry("Romania");
				task.setCity("Timisoara");
				task.setDescription("Gasiti masinile rosii");
				task.setDueDate(Calendar.getInstance().getTime());
				task.setState(TaskState.UNASSIGNED);
				task.getAnswers().add(answer);

				session.save(task);

				answer.setTask(task);

			}

		}.run();
	}
}
