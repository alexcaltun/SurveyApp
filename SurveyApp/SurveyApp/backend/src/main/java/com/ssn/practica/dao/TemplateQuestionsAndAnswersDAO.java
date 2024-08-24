package com.ssn.practica.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TemplateQuestionsAndAnswersDAO {

	public List<String> getAllQuestions() throws IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource("questions.txt");

		if (resource == null) {
			throw new IOException("File not found! Check the path and ensure the file exists in the resources folder.");
		}

		Path path = Paths.get(resource.toURI());
		return Files.readAllLines(path);
	}

	public List<List<String>> getAllAnswers() throws IOException, URISyntaxException {
		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource("answers.txt");

		if (resource == null) {
			throw new IOException("File not found! Check the path and ensure the file exists in the resources folder.");
		}

		Path filePath = Paths.get(resource.toURI());
		List<String> lines = Files.readAllLines(filePath);
		List<List<String>> allAnswers = new ArrayList<>();

		for (String line : lines) {
			String[] answers = line.split(";");
			allAnswers.add(Arrays.asList(answers));
		}

		return allAnswers;
	}

}
