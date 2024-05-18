package com.school.test.service;

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
	
	@Autowired
	private SchoolRepository Schoolrepo;

	
	
	public Student addStudent(final Student student) throws AccountNotFoundException
	{
		boolean check = Schoolrepo.existsBySchoolName(student.getSchoolName());
		if(!check)
		{
			throw new AccountNotFoundException("School not Found");
		}
		return this.studentrespository.save(student);
	}
}
