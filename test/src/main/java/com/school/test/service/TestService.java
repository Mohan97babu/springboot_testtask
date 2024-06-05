package com.school.test.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.school.test.dto.PaginatedResponseDTO;
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
	
//	public List<ResponseTestDTO> retrieveTest()
//	{
//		List<Test> data = this.testRepo.findAll();
//		List<ResponseTestDTO> resList = new ArrayList<>();
//		for(Test test:data)
//		{
//			ResponseTestDTO temp = new ResponseTestDTO();
//			temp.setId(test.getId());
//			temp.setTestDate(test.getTestDate());
//			temp.setTestName(test.getTestName());
//			resList.add(temp);
//		}
//		return resList;
//		
//	}
	public PaginatedResponseDTO<Test> retrieveTest(int page,int size)
	{
//		List<Test> data = this.testRepo.findAll();
//		List<ResponseTestDTO> resList = new ArrayList<>();
//		for(Test test:data)
//		{
//			ResponseTestDTO temp = new ResponseTestDTO();
//			temp.setId(test.getId());
//			temp.setTestDate(test.getTestDate());
//			temp.setTestName(test.getTestName());
//			resList.add(temp);
//		}
		Page<Test> testPage = this.testRepo.findAll(PageRequest.of(page, size));
		
		PaginatedResponseDTO<Test> response = new PaginatedResponseDTO<>();
		response.setData(testPage.getContent());
		response.setPageNumber(testPage.getNumber());
		response.setTotalElements(testPage.getTotalElements());
		response.setPageSize(testPage.getSize());
		response.setTotalPages(testPage.getTotalPages());
		
		return response;
		
	}
}
