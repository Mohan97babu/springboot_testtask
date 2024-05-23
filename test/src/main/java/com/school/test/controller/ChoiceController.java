package com.school.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.Choice;

import com.school.test.service.ChoiceService;


@RestController
@RequestMapping("/api/v1")
public class ChoiceController {

	@Autowired
	ChoiceService choiceservice;
	
	@PostMapping("/choice")
   public Map<String,String> addChoice(@RequestBody Choice choice)
   {
	   return this.choiceservice.addChoice(choice);
   }
	@GetMapping("/choice")
	public List<Choice> retrieveChoice()
	{
		return this.choiceservice.retrieveChoice();	
	} 
}
