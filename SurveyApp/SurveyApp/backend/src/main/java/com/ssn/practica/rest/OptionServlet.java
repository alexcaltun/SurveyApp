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

import com.ssn.practica.dao.OptionDAO;
import com.ssn.practica.dto.OptionDTO;

@Path("/options")
public class OptionServlet {
	OptionDAO optionDAO = new OptionDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addOption(OptionDTO optionDTO) {
		optionDAO.addOption(OptionDTO.fromOptionDTO(optionDTO));
	}

	@DELETE
	@Path("deleteOption/{optionId}")
	public void deleteOption(@PathParam("optionId") String optionId) {
		optionDAO.deleteOption(optionId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateOption(OptionDTO optionDTO) {
		optionDAO.updateOption(OptionDTO.fromOptionDTO(optionDTO));
	}

	@GET
	@Path("getOptionByOptionId/{optionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OptionDTO getOptionByOptionId(@PathParam("optionId") String optionId) {
		return OptionDTO.fromOption(optionDAO.getOptionByOptionId(optionId));
	}
}
