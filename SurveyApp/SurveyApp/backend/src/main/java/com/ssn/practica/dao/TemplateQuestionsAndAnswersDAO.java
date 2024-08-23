package com.ssn.practica.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemplateQuestionsAndAnswersDAO {

	public List<String> getAllQuestions() throws IOException {
		// Path filePath = Paths.get(
		// "C:\\Users\\Alex
		// Caltun\\git\\SurveyAppGood\\SurveyApp\\SurveyApp\\SurveyApp\\backend\\src\\main\\java\\com\\ssn\\practica\\txtFile\\questions.txt");
		Path filePath = Paths.get("/backend/src/main/java/com/ssn/practica/txtFile/questions.txt");
		List<String> questions = Files.readAllLines(filePath);
		return questions;
	}

	public List<List<String>> getAllAnswers() throws IOException {
		// Path filePath = Paths.get(
		// "C:\\Users\\Alex
		// Caltun\\git\\SurveyAppGood\\SurveyApp\\SurveyApp\\SurveyApp\\backend\\src\\main\\java\\com\\ssn\\practica\\txtFile\\answers.txt");
		Path filePath = Paths.get("/backend/src/main/java/com/ssn/practica/txtFile/answers.txt");
		List<String> lines = Files.readAllLines(filePath);
		List<List<String>> allAnswers = new ArrayList<>();
		for (String line : lines) {
			String[] answers = line.split(";");
			allAnswers.add(Arrays.asList(answers));
		}
		return allAnswers;
	}

}
