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

import com.ssn.practica.dao.AnswerDAO;
import com.ssn.practica.dto.AnswerDTO;
import com.ssn.practica.model.Answer;

@Path("/answers")
public class AnswerServlet {
	AnswerDAO answerDAO = new AnswerDAO();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAnswer(AnswerDTO answerDTO) {
		answerDAO.addAnswer(AnswerDTO.fromAnswerDTO(answerDTO));
	}

	@DELETE
	@Path("deleteAnswer/{answerId}")
	public void deleteAnswer(@PathParam("answerId") String answerId) {
		answerDAO.deleteAnswer(answerId);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateAnswer(AnswerDTO answerDTO) {
		answerDAO.updateAnswer(AnswerDTO.fromAnswerDTO(answerDTO));
	}

	@GET
	@Path("getAnswerByAnswerId/{answerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public AnswerDTO getAnswerByAnswerId(@PathParam("answerId") String answerId) {
		return AnswerDTO.fromAnswer(answerDAO.getAnswerByAnswerId(answerId));
	}

	@GET
	@Path("getAnswersByQuestionId/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AnswerDTO> getAnswersByQuestionId(@PathParam("questionId") String questionId) {
		List<Answer> answers = answerDAO.getAnswersByQuestionId(questionId);
		List<AnswerDTO> answerDTOs = answers.stream().map(AnswerDTO::fromAnswer).collect(Collectors.toList());
		return answerDTOs;
	}

}
