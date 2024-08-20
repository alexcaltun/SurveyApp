package com.ssn.practica.rest;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.SurveyDAO;
import com.ssn.practica.dto.SurveyDTO;
import com.ssn.practica.model.Survey;

@Path("/surveys")
public class SurveyServlet {
	SurveyDAO surveyDAO = new SurveyDAO();

//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void addSurvey(SurveyDTO surveyDTO) {
//		surveyDAO.addSurvey(SurveyDTO.fromSurveyDTO(surveyDTO));
//	}

	@DELETE
	@Path("deleteSurvey/{surveyId}")
	public void deleteSurvey(@PathParam("surveyId") String surveyId) {
		surveyDAO.deleteSurvey(surveyId);
	}

//	@PUT
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void updateSurvey(SurveyDTO surveyDTO) {
//		surveyDAO.updateSurvey(SurveyDTO.fromSurveyDTO(surveyDTO));
//	}

	@GET
	@Path("getSurveyBySurveynId/{survayId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SurveyDTO getSurveyBySurveyId(@PathParam("surveynId") String surveyId) {
		return SurveyDTO.fromSurvey(surveyDAO.getSurveyBySurveyId(surveyId));
	}

	@GET
	@Path("getSurveysByDueDate")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SurveyDTO> getSurveysByDueDate(@QueryParam("dueDate") Date dueDate) {
		List<Survey> surveys = surveyDAO.getSurveysByDueDate(dueDate);
		List<SurveyDTO> surveyDTOs = surveys.stream().map(SurveyDTO::fromSurvey).collect(Collectors.toList());
		return surveyDTOs;
	}
}
