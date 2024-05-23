package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Test;
import com.school.test.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepo;
	
	public Map<String,String> addTest(final Test test)
	{
		Map<String,String> response = new LinkedHashMap<>();
		this.testRepo.save(test);
		response.put("id", test.getId()+"");
	    response.put("message", "test added successfully");
		return response;
	}
	
	public List<Test> retrieveTest()
	{
		return this.testRepo.findAll();	
	}
}
