package com.ssn.practica.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ssn.practica.dao.TemplateQuestionsAndAnswersDAO;

public class TemplateQuestionsAndAnswersServlet {
	TemplateQuestionsAndAnswersDAO templateQuestionsAndAnswersDAO = new TemplateQuestionsAndAnswersDAO();

	@GET
	@Path("getAllQuestions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllQuestions() throws IOException {
		return templateQuestionsAndAnswersDAO.getAllQuestions();
	}

	@GET
	@Path("getAllAnswers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<List<String>> getAllAnswers() throws IOException {
		return templateQuestionsAndAnswersDAO.getAllAnswers();
	}
}
