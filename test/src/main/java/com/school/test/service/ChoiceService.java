package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Choice;

import com.school.test.repository.ChoiceRepository;


@Service
public class ChoiceService {
  
	@Autowired
	ChoiceRepository choicerepository;
	
	
	public Map<String,String> addChoice(final Choice choice)
	{
		Map<String,String> response = new LinkedHashMap<>();
		this.choicerepository.save(choice);
		response.put("id", choice.getId()+"");
		response.put("questionId",choice.getQuestion().getId()+"");
	    response.put("message", "choice added successfully");
		return response;
	} 
	public List<Choice> retrieveChoice()
	{
		return this.choicerepository.findAll();
	}
}
