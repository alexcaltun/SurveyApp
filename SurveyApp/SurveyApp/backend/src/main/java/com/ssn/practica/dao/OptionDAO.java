package com.ssn.practica.dao;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Option;

public class OptionDAO {
	public void addOption(Option option) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(option);
			}

		}.run();
	}

	public void deleteOption(String id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Option option = session.get(Option.class, id);
				if (option != null) {
					session.delete(option);
				}
			}
		}.run();
	}

	public void updateOption(Option option) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(option);
			}
		}.run();
	}

	public Option getOptionByOptionId(String optionId) {
		return new WithSessionAndTransaction<Option>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Option option = session.createQuery("SELECT o FROM Option o WHERE o.optionId = :optionId", Option.class)
						.setParameter("optionId", optionId).uniqueResult();
				setReturnValue(option);
			}
		}.run();
	}
}
