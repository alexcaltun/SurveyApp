package com.ssn.practica.rest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.TaskDAO;
import com.ssn.practica.dto.TaskDTO;
import com.ssn.practica.model.Task;

@Path("/tasks")
public class TaskServlet {
	TaskDAO taskDAO = new TaskDAO();

	@GET
	@Path("getTasks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskDTO> getTasks() {
		List<Task> tasks = taskDAO.getTasks();
		List<TaskDTO> taskDTOs = tasks.stream().map(TaskDTO::fromTask).collect(Collectors.toList());
		return taskDTOs;
	}

	@GET
	@Path("getTaskByTaskId/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TaskDTO getTaskByTaskId(@PathParam("taskId") String taskId) {
		Task task = taskDAO.getTaskByTaskId(taskId);
		return TaskDTO.fromTask(task);
	}

	@GET
	@Path("getTasksByState/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskDTO> getTasksByState(@PathParam("state") String state) {
		List<Task> tasks = taskDAO.getTasksByState(state);
		List<TaskDTO> taskDTOs = tasks.stream().map(TaskDTO::fromTask).collect(Collectors.toList());
		return taskDTOs;
	}

	@GET
	@Path("getTasksByDueDate")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TaskDTO> getTasksByDueDate(@QueryParam("dueDate") Date dueDate) {
		List<Task> tasks = taskDAO.getTasksByDueDate(dueDate);
		List<TaskDTO> taskDTOs = tasks.stream().map(TaskDTO::fromTask).collect(Collectors.toList());
		return taskDTOs;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addTask(TaskDTO taskDTO) {
		taskDAO.addTask(TaskDTO.fromTaskDTO(taskDTO));
	}

	@DELETE
	@Path("deleteTask/{taskId}")
	public void deleteTask(@PathParam("taskId") String taskId) {
		taskDAO.deleteTask(taskId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateTask(TaskDTO taskDTO) {
		taskDAO.updateTask(TaskDTO.fromTaskDTO(taskDTO));
	}
}
