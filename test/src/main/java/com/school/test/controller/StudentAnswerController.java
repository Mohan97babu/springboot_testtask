package com.school.test.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.StudentAnswer;
import com.school.test.service.StudentAnswerService;

@RestController
@RequestMapping("/api/v1")
public class StudentAnswerController {
	
	@Autowired
	StudentAnswerService studentanswerservice;
	
	@PostMapping("/student-answer")
	public Map<String,String> addStudentAnswer(@RequestBody StudentAnswer studentanswer)
	{
		return this.studentanswerservice.addStudentAnswer(studentanswer);
	}
   
}
