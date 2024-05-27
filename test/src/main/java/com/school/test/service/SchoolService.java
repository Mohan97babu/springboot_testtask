package com.school.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.School;
import com.school.test.repository.SchoolRepository;

@Service
public class SchoolService {

	@Autowired
	SchoolRepository schoolrepository;
	
	public School createSchool(final School school)
	{
		return this.schoolrepository.save(school);
	}
	
	public List<School> retrieveSchool()
	{
		return this.schoolrepository.findAll();
	}
}
