package com.ssn.practica.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.QuestionTemplateDAO;
import com.ssn.practica.dto.QuestionTemplateDTO;

public class QuestionTemplateServlet {
	QuestionTemplateDAO questionTemplateDAO = new QuestionTemplateDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addQuestionTemplate(QuestionTemplateDTO questionTemplateDTO) {
		questionTemplateDAO.addQuestionTemplate(QuestionTemplateDTO.fromQuestionTemplateDTO(questionTemplateDTO));
	}

	@DELETE
	@Path("deleteQuestionTemplate/{questionId}")
	public void deleteQuestionTemplate(@PathParam("questionId") String questionId) {
		questionTemplateDAO.deleteQuestionTemplate(questionId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateQuestionTemplate(QuestionTemplateDTO questionTemplateDTO) {
		questionTemplateDAO.updateQuestionTemplate(QuestionTemplateDTO.fromQuestionTemplateDTO(questionTemplateDTO));
	}
}
