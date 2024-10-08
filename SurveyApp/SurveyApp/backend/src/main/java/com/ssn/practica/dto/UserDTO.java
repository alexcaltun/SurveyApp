package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssn.practica.model.Survey;
import com.ssn.practica.model.User;

public class UserDTO {

	private String username;
	private String email;
	private String password;

	private List<SurveyDTO> surveys = new ArrayList<SurveyDTO>();

	public UserDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SurveyDTO> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<SurveyDTO> surveys) {
		this.surveys = surveys;
	}

	public static UserDTO fromUser(User user) {
		UserDTO userDTO = new UserDTO();

		userDTO.setEmail(user.getEmail());
		userDTO.setUsername(user.getUsername());
		for (Survey survey : user.getSurveys()) {
			SurveyDTO surveyDTO = SurveyDTO.fromSurvey(survey);
			userDTO.getSurveys().add(surveyDTO);
		}

		return userDTO;

	}

	public static User fromUserDTO(UserDTO userDTO) {

		User user = new User();

		user.setEmail(userDTO.getEmail());
		user.setUsername(userDTO.getUsername());
		for (SurveyDTO surveyDTO : userDTO.getSurveys()) {
			Survey survey = SurveyDTO.fromSurveyDTO(surveyDTO);
			user.getSurveys().add(survey);
		}

		return user;

	}
}
