package com.school.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.Question;
import com.school.test.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionrepository;
	
	
	public ResponsePostDTO addQuestion(final Question question)
	{
		this.questionrepository.save(question);
		ResponsePostDTO temp = new ResponsePostDTO();
		temp.setId(question.getId());
		temp.setMessage("Question Added Successfully");
		
		return temp;
	}
	
	public List<Question> retrieveQuestion()
	{
		return this.questionrepository.findAll();	
	}
}
