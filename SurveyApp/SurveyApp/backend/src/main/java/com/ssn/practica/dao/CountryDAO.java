package com.ssn.practica.dao;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Country;

public class CountryDAO {
	public void addCountry(Country country) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(country);
			}

		}.run();
	}

	public void deleteCountry(String name) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Country country = session.get(Country.class, name);
				if (country != null) {
					session.delete(country);
				}
			}
		}.run();
	}

	public void updateCountry(Country country) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(country);
			}
		}.run();
	}

	public Country getCountryByName(String name) {
		return new WithSessionAndTransaction<Country>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Country country = session.createQuery("SELECT c FROM Country c WHERE c.name = :name", Country.class)
						.setParameter("name", name).uniqueResult();
				setReturnValue(country);
			}
		}.run();
	}

	public Country getCountryByUserUsername(String username) {
		return new WithSessionAndTransaction<Country>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Country country = session
						.createQuery("SELECT c FROM Country c WHERE c.countryUser.username = :username", Country.class)
						.setParameter("username", username).uniqueResult();
				setReturnValue(country);
			}
		}.run();
	}

	public Country getCountryByCityName(String cityName) {
		return new WithSessionAndTransaction<Country>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Country country = session
						.createQuery("SELECT c FROM Country c WHERE c.city.name = :cityName", Country.class)
						.setParameter("cityName", cityName).uniqueResult();
				setReturnValue(country);
			}
		}.run();
	}
}
