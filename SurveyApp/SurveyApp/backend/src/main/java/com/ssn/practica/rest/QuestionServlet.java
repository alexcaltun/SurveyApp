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

import com.ssn.practica.dao.QuestionDAO;
import com.ssn.practica.dto.QuestionDTO;
import com.ssn.practica.model.Question;

@Path("/questions")
public class QuestionServlet {
	QuestionDAO questionDAO = new QuestionDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addQuestion(QuestionDTO questionDTO) {
		questionDAO.addQuestion(QuestionDTO.fromQuestionDTO(questionDTO));
	}

	@DELETE
	@Path("deleteQuestion/{questionId}")
	public void deleteQuestion(@PathParam("questionId") String questionId) {
		questionDAO.deleteQuestion(questionId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateQuestion(QuestionDTO questionDTO) {
		questionDAO.updateQuestion(QuestionDTO.fromQuestionDTO(questionDTO));
	}

	@GET
	@Path("getQuestionByQuestionId/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public QuestionDTO getQuestionByQuestionId(@PathParam("questionId") String questionId) {
		return QuestionDTO.fromQuestion(questionDAO.getQuestionByQuestionId(questionId));
	}

	@GET
	@Path("getQuestionsBySurveyId/{surveyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionDTO> getQuestionsBySurveyId(@PathParam("surveyId") String surveyId) {
		List<Question> questions = questionDAO.getQuestionsBySurveyId(surveyId);
		List<QuestionDTO> questionDTOs = questions.stream().map(QuestionDTO::fromQuestion).collect(Collectors.toList());
		return questionDTOs;
	}
}
