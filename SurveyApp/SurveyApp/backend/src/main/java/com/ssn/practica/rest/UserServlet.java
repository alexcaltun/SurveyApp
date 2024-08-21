package com.ssn.practica.rest;

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
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.UserDAO;
import com.ssn.practica.dto.UserDTO;
import com.ssn.practica.model.User;

@Path("/users")
public class UserServlet {
	UserDAO userDAO = new UserDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addUser(UserDTO userDTO) {
		userDAO.addUser(UserDTO.fromUserDTO(userDTO));
	}

	@DELETE
	@Path("deleteUser/{userId}")
	public void deleteUser(@PathParam("userId") String userId) {
		userDAO.deleteUser(userId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(UserDTO userDTO) {
		userDAO.updateUser(UserDTO.fromUserDTO(userDTO));
	}

	@GET
	@Path("getUsersByCountry/{country}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getUsersByCountry(@PathParam("country") String country) {
		List<User> users = userDAO.getUsersByCountry(country);
		List<UserDTO> userDTOs = users.stream().map(UserDTO::fromUser).collect(Collectors.toList());
		return userDTOs;
	}
}
