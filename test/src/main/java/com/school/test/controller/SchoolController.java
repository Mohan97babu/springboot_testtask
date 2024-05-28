package com.school.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.School;
import com.school.test.service.SchoolService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/v1")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolservice;
	
	@PostMapping("/school")
    public School createSchool(@RequestBody School school)
    {
	   return this.schoolservice.createSchool(school);
    }
	
	@GetMapping("/school")
	public List<School> retrieveSchool()
	{
		return this.schoolservice.retrieveSchool();
	}
}
