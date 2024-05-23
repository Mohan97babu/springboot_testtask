package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Question;
import com.school.test.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionrepository;
	
	
	public Map<String,String> addQuestion(final Question question)
	{
		Map<String,String> response = new LinkedHashMap<>();
		this.questionrepository.save(question);
		response.put("id", question.getId()+"");
		response.put("tutorId",question.getTest().getId()+"");
	    response.put("message", "test added successfully");
		return response;
	}
	public List<Question> retrieveQuestion()
	{
		return this.questionrepository.findAll();	
	}
}
