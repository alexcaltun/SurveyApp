package com.ssn.practica.dao;

import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.User;

public class UserDAO {
	public void addUser(User user) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(user);
			}

		}.run();
	}

	public void deleteUser(String id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				User user = session.get(User.class, id);
				if (user != null) {
					session.delete(user);
				}
			}
		}.run();
	}

	public void updateUser(User user) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(user);
			}
		}.run();
	}

//	public User getUserByUserId(String userId) {
//		return new WithSessionAndTransaction<User>() {
//			@Override
//			protected void executeBusinessLogic(Session session) {
//				User user = session.createQuery("SELECT u FROM User u WHERE u.userId = :userId", User.class)
//						.setParameter("userId", userId).uniqueResult();
//				setReturnValue(user);
//			}
//		}.run();
//	}

	public List<User> getUsersByCountry(String country) {
		return new WithSessionAndTransaction<List<User>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<User> users = session.createQuery("SELECT u FROM User u WHERE u.country = :country", User.class)
						.setParameter("country", country).getResultList();
				setReturnValue(users);
			}
		}.run();
	}
}
