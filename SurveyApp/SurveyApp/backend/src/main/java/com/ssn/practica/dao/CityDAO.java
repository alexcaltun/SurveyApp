package com.ssn.practica.dao;

import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.City;

public class CityDAO {
	public void addCity(City city) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(city);
			}

		}.run();
	}

	public void deleteCity(String name) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				City city = session.get(City.class, name);
				if (city != null) {
					session.delete(city);
				}
			}
		}.run();
	}

	public void updateCity(City city) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(city);
			}
		}.run();
	}

	public City getCityByName(String name) {
		return new WithSessionAndTransaction<City>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				City city = session.createQuery("SELECT c FROM City c WHERE c.name = :name", City.class)
						.setParameter("name", name).uniqueResult();
				setReturnValue(city);
			}
		}.run();
	}

	public List<City> getCitiesByCountryName(String countryName) {
		return new WithSessionAndTransaction<List<City>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<City> cities = session
						.createQuery("SELECT c FROM City c WHERE c.country.name = :countryName", City.class)
						.setParameter("countryName", countryName).getResultList();
				setReturnValue(cities);
			}
		}.run();
	}
}
