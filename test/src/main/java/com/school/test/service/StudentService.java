package com.school.test.service;


import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.Student;
import com.school.test.repository.StudentRepository;

@Service
public class StudentService {
   
	@Autowired
	private StudentRepository studentrespository;

	
	public ResponsePostDTO addStudent(final Student student) throws AccountNotFoundException
	{
		Student savedStudent = this.studentrespository.save(student);

		ResponsePostDTO response = new ResponsePostDTO();
		response.setId(savedStudent.getId());
		response.setMessage("Student is added successfully");
		return response;
	}
	
	public List<Student> retrieveStudent()
	{
		return this.studentrespository.findAll();
	}
}
