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

import com.ssn.practica.dao.CityDAO;
import com.ssn.practica.dto.CityDTO;
import com.ssn.practica.model.City;

@Path("/cities")
public class CityServlet {
	CityDAO cityDAO = new CityDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCity(CityDTO cityDTO) {
		cityDAO.addCity(CityDTO.fromCityDTO(cityDTO));
	}

	@DELETE
	@Path("deleteCity/{name}")
	public void deleteCity(@PathParam("name") String name) {
		cityDAO.deleteCity(name);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateCity(CityDTO cityDTO) {
		cityDAO.updateCity(CityDTO.fromCityDTO(cityDTO));
	}

	@GET
	@Path("getCityByName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public CityDTO getCityByName(@PathParam("name") String name) {
		return CityDTO.fromCity(cityDAO.getCityByName(name));
	}

	@GET
	@Path("getCitiesByCountryName/{countryName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CityDTO> getCitiesByCountryName(@PathParam("countryName") String countryName) {
		List<City> cities = cityDAO.getCitiesByCountryName(countryName);
		List<CityDTO> cityDTOs = cities.stream().map(CityDTO::fromCity).collect(Collectors.toList());
		return cityDTOs;
	}
}
