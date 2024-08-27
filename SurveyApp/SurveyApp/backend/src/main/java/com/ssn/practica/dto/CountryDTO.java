package com.ssn.practica.dto;

import java.util.ArrayList;
import java.util.List;

import com.ssn.practica.dao.SurveyTemplateDAO;
import com.ssn.practica.dao.UserDAO;
import com.ssn.practica.model.City;
import com.ssn.practica.model.Country;
import com.ssn.practica.model.SurveyTemplate;
import com.ssn.practica.model.User;

public class CountryDTO {
	private String name;
	private String userUsername;
	private List<CityDTO> cities = new ArrayList<CityDTO>();
	private String surveyTemplateId;

	public CountryDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public List<CityDTO> getCities() {
		return cities;
	}

	public void setCities(List<CityDTO> cities) {
		this.cities = cities;
	}

	public String getSurveyTemplateId() {
		return surveyTemplateId;
	}

	public void setSurveyTemplateId(String surveyTemplateId) {
		this.surveyTemplateId = surveyTemplateId;
	}

	public static CountryDTO fromCountry(Country country) {
		CountryDTO countryDTO = new CountryDTO();

		countryDTO.setName(country.getName());
		countryDTO.setUserUsername(country.getCountryUser().getUsername());
		countryDTO.setSurveyTemplateId(country.getSurveyTemplate().getSurveyId());

		for (City city : country.getCities()) {
			CityDTO cityDTO = CityDTO.fromCity(city);
			countryDTO.getCities().add(cityDTO);
		}

		return countryDTO;
	}

	public static Country fromCountryDTO(CountryDTO countryDTO) {
		Country country = new Country();

		country.setName(countryDTO.getName());

		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUsername(countryDTO.getUserUsername());
		country.setCountryUser(user);

		SurveyTemplateDAO surveyTemplateDAO = new SurveyTemplateDAO();
		SurveyTemplate surveyTemplate = surveyTemplateDAO.getSurveyTemplateBySurveyId(countryDTO.getSurveyTemplateId());
		country.setSurveyTemplate(surveyTemplate);

		for (CityDTO cityDTO : countryDTO.getCities()) {
			City city = CityDTO.fromCityDTO(cityDTO);
			country.getCities().add(city);
		}

		return country;
	}
}
