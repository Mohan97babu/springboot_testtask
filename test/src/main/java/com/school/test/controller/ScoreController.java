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
import com.school.test.service.ScoreService;

@RestController
@RequestMapping("/api/v1")
public class ScoreController {

	@Autowired
	ScoreService scoreservice;
//	
//	@PostMapping("/score")
//	public Map<String,String> addScore(@RequestBody Score score )
//	{
//		return this.scoreservice.addScore(score);
//	}
//	
	@GetMapping("/score")
	public List<Score> retrieveScore()
	{
		return this.scoreservice.retrieveScore();
	}
	
	@GetMapping("/score/{id}")
	public List<Score> retrieveStudentScores(@PathVariable Long id)
	{
		return this.scoreservice.retrieveStudentScores(id);
	}
}
