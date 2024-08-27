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

import com.ssn.practica.dao.SurveyTemplateDAO;
import com.ssn.practica.dto.SurveyTemplateDTO;

public class SurveyTemplateServlet {
	SurveyTemplateDAO surveyTemplateDAO = new SurveyTemplateDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCity(SurveyTemplateDTO surveyTemplateDTO) {
		surveyTemplateDAO.addSurveyTemplate(SurveyTemplateDTO.fromSurveyTemplateDTO(surveyTemplateDTO));
	}

	@DELETE
	@Path("deleteSurveyTemplate/{questionId}")
	public void deleteSurveyTemplate(@PathParam("surveyId") String surveyId) {
		surveyTemplateDAO.deleteSurveyTemplate(surveyId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateSurveyTemplate(SurveyTemplateDTO surveyTemplateDTO) {
		surveyTemplateDAO.updateSurveyTemplate(SurveyTemplateDTO.fromSurveyTemplateDTO(surveyTemplateDTO));
	}

	@GET
	@Path("getSurveyTemplateyBySurveyId/{surveyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SurveyTemplateDTO getSurveyTemplateBySurveyId(@PathParam("surveyId") String surveyId) {
		return SurveyTemplateDTO.fromSurveyTemplate(surveyTemplateDAO.getSurveyTemplateBySurveyId(surveyId));
	}
}
