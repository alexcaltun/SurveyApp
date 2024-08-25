package com.ssn.practica.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.CountryDAO;
import com.ssn.practica.dto.CountryDTO;

@Path("/countries")
public class CountryServlet {
	CountryDAO countryDAO = new CountryDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCountry(CountryDTO countryDTO) {
		countryDAO.addCountry(CountryDTO.fromCountryDTO(countryDTO));
	}

	@DELETE
	@Path("deleteCountry/{name}")
	public void deleteCountry(@PathParam("name") String name) {
		countryDAO.deleteCountry(name);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCountry(CountryDTO countryDTO) {
		countryDAO.updateCountry(CountryDTO.fromCountryDTO(countryDTO));
	}

	@GET
	@Path("getCountryByName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public CountryDTO getCountryByName(@PathParam("name") String name) {
		return CountryDTO.fromCountry(countryDAO.getCountryByName(name));
	}

	@GET
	@Path("getCountryByUserUsername/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public CountryDTO getCountryByUserUsername(@PathParam("username") String username) {
		return CountryDTO.fromCountry(countryDAO.getCountryByUserUsername(username));
	}

	@GET
	@Path("getCountryByCityName/{cityName}")
	@Produces(MediaType.APPLICATION_JSON)
	public CountryDTO getCountryByCityName(@PathParam("cityName") String cityName) {
		return CountryDTO.fromCountry(countryDAO.getCountryByCityName(cityName));
	}
}
