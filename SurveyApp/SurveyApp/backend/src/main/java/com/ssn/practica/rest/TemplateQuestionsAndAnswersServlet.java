package com.ssn.practica.rest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.TemplateQuestionsAndAnswersDAO;

@Path("/templates")
public class TemplateQuestionsAndAnswersServlet {
	TemplateQuestionsAndAnswersDAO templateQuestionsAndAnswersDAO = new TemplateQuestionsAndAnswersDAO();

	@GET
	@Path("/getAllQuestions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllQuestions() throws IOException, URISyntaxException {
		return templateQuestionsAndAnswersDAO.getAllQuestions();
	}

	@GET
	@Path("/getAllAnswers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<List<String>> getAllAnswers() throws IOException, URISyntaxException {
		return templateQuestionsAndAnswersDAO.getAllAnswers();
	}
}
