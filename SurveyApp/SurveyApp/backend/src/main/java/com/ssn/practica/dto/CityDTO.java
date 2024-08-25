package com.ssn.practica.dto;

import com.ssn.practica.dao.CountryDAO;
import com.ssn.practica.model.City;
import com.ssn.practica.model.Country;

public class CityDTO {
	private String Name;
	private String CountryName;
	private String surveyTemplateId;

	public CityDTO() {
		super();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public String getSurveyTemplateId() {
		return surveyTemplateId;
	}

	public void setSurveyTemplateId(String surveyTemplateId) {
		this.surveyTemplateId = surveyTemplateId;
	}

	public static CityDTO fromCity(City city) {
		CityDTO cityDTO = new CityDTO();

		cityDTO.setName(city.getName());
		cityDTO.setCountryName(city.getCountry().getName());
		cityDTO.setSurveyTemplateId(city.getSurveyTemplate().getSurveyId());

		return cityDTO;
	}

	public static City fromCityDTO(CityDTO cityDTO) {
		City city = new City();

		city.setName(cityDTO.getName());

		CountryDAO countryDAO = new CountryDAO();
		Country country = countryDAO.getCountryByCityName(cityDTO.getName());
		city.setCountry(country);

//		SurveyTemplateDAO surveyTemplateDAO = new SurveyTemplateDAO();
//		SurveyTemplate surveyTemplate = surveyTemplateDAO
//				.getSurveyTemplateBySurveyTemplateId(cityDTO.getSurveyTemplateId());
//		city.setSurveyTemplate(surveyTemplate);

		return city;
	}
}
