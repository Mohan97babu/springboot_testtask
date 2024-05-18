package com.school.test.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.Student;
import com.school.test.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	StudentService studentservice;
   
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) throws AccountNotFoundException
	{
		return this.studentservice.addStudent(student);
	}
}
