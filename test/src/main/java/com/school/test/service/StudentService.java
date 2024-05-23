package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Student;
import com.school.test.repository.SchoolRepository;
import com.school.test.repository.StudentRepository;

@Service
public class StudentService {
   
	@Autowired
	private StudentRepository studentrespository;

	
	public Map<String,String> addStudent(final Student student) throws AccountNotFoundException
	{
		Map<String,String> response = new LinkedHashMap<>();
		Student savedStudent = this.studentrespository.save(student);
		response.put("id", savedStudent.getId()+"");
		response.put("schoolId", savedStudent.getSchool().getId()+"");
		response.put("message","Student is added successfully");
		return response;
	}
	
	public List<Student> retrieveStudent()
	{
		return this.studentrespository.findAll();
	}
}
