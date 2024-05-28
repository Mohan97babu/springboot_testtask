package com.school.test.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.Student;
import com.school.test.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
   
	@PostMapping("/student")
	public ResponsePostDTO addStudent(@RequestBody Student student) throws AccountNotFoundException
	{
		return this.studentservice.addStudent(student);
	}
	
	@GetMapping("/student")
	public List<Student> retrieveStudent()
	{
		return this.studentservice.retrieveStudent();
	}
}
