package com.school.test.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponsePostDTO;
import com.school.test.dto.ResponseTestDTO;
import com.school.test.entity.Test;
import com.school.test.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepo;
	
	public ResponsePostDTO addTest(final Test test)
	{

		this.testRepo.save(test);

	    ResponsePostDTO response = new ResponsePostDTO();
		response.setId(test.getId());
		response.setMessage("Test is added successfully");
		return response;
	}
	
	public List<ResponseTestDTO> retrieveTest()
	{
		List<Test> data = this.testRepo.findAll();
		List<ResponseTestDTO> resList = new ArrayList<>();
		for(Test test:data)
		{
			ResponseTestDTO temp = new ResponseTestDTO();
			temp.setId(test.getId());
			temp.setTestDate(test.getTestDate());
			temp.setTestName(test.getTestName());
			resList.add(temp);
		}
		return resList;
		
	}
}
