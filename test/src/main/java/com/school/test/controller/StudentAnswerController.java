package com.school.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.StudentAnswer;
import com.school.test.service.StudentAnswerService;

@RestController
@RequestMapping("/api/v1")
public class StudentAnswerController {
	
	@Autowired
	private StudentAnswerService studentanswerservice;
	
	@PostMapping("/student-answer")
	public ResponsePostDTO addStudentAnswer(@RequestBody StudentAnswer studentanswer)
	{
		return this.studentanswerservice.addStudentAnswer(studentanswer);
	}
   
}
