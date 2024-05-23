package com.school.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.Question;

import com.school.test.service.QuestionService;


@RestController
@RequestMapping("/api/v1")
public class QuestionController {
	
	
	@Autowired
	QuestionService questionservice;
	
	@PostMapping("/question")
   public Map<String,String> addQuestion(@RequestBody Question question)
   {
	   return this.questionservice.addQuestion(question);
   }
	
	@GetMapping("/question")
	public List<Question> retrieveQuestion()
	{
		return this.questionservice.retrieveQuestion();	
	}
}
