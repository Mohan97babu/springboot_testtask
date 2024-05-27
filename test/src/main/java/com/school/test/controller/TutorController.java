package com.school.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.entity.Score;
import com.school.test.entity.Tutor;
import com.school.test.service.TutorService;

@RestController
@RequestMapping("api/v1")
public class TutorController {
	
	@Autowired
	TutorService tutorservice;
	
   
	@PostMapping("/tutor")
	public Map<String,String> addTutor(@RequestBody Tutor tutor)
	{
		return this.tutorservice.addTutor(tutor);
	}
	
	@GetMapping("/tutor")
	public List<Tutor> retrieveTutor()
	{
		return this.tutorservice.retrieveTutor();
	}
	
	 @GetMapping("/tutors/scores/{tutorId}")
	 public List<Score> getStudentScores(@PathVariable long tutorId) 
	 {
	    return this.tutorservice.getStudentScoresUnderTutor(tutorId);
	 }
	
}
