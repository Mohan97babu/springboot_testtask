package com.school.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.Test;
import com.school.test.service.TestService;

@RestController
@RequestMapping("/api/v1")
public class TestController {
	
	@Autowired
	TestService testservice;

	@PostMapping("/test")
	public Map<String,String> addTest(@RequestBody Test test)
	{
		return this.testservice.addTest(test);
	}
	@GetMapping("/test")
	public List<Test> retrieveTest()
	{
		return this.testservice.retrieveTest();
	}
}
