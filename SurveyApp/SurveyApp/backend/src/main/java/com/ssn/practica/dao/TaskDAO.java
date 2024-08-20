package com.ssn.practica.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.ssn.core.persistence.WithSessionAndTransaction;
import com.ssn.practica.model.Task;

public class TaskDAO {

	public List<Task> getTasks() {
		return new WithSessionAndTransaction<List<Task>>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				List<Task> tasks = session.createQuery("from Task").getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}

	public void addTask(Task task) {
		new WithSessionAndTransaction<Void>() {

			@Override
			protected void executeBusinessLogic(Session session) {
				session.save(task);
			}

		}.run();
	}

	public void deleteTask(String id) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Task task = session.get(Task.class, id);
				if (task != null) {
					session.delete(task);
				}
			}
		}.run();
	}

	public void updateTask(Task task) {
		new WithSessionAndTransaction<Void>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				session.update(task);
			}
		}.run();
	}

	public Task getTaskByTaskId(String taskId) {
		return new WithSessionAndTransaction<Task>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				Task task = session.createQuery("SELECT t FROM Task t WHERE t.taskId = :taskId", Task.class)
						.setParameter("taskId", taskId).uniqueResult();
				setReturnValue(task);
			}
		}.run();
	}

	public List<Task> getTasksByState(String state) {
		return new WithSessionAndTransaction<List<Task>>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				List<Task> tasks = session.createQuery("SELECT t FROM Task t WHERE t.state = :state", Task.class)
						.setParameter("state", state).getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}

	public List<Task> getTasksByDueDate(Date dueDate) {
		return new WithSessionAndTransaction<List<Task>>() {
			@Override
			protected void executeBusinessLogic(Session session) {
				List<Task> tasks = session.createQuery("SELECT t FROM Task t WHERE t.dueDate = :dueDate", Task.class)
						.setParameter("dueDate", dueDate).getResultList();
				setReturnValue(tasks);
			}
		}.run();
	}
}
