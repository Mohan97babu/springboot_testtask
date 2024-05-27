package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Question;
import com.school.test.entity.Score;
import com.school.test.repository.ChoiceRepository;
import com.school.test.repository.QuestionRepository;
import com.school.test.repository.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	ScoreRepository scorerepository;
	
	@Autowired
	QuestionRepository questionrepository;
	
	@Autowired
	ChoiceRepository choicerepository;
	
	
	public List<Score> retrieveScore()
	{
		return this.scorerepository.findAll();	
	}
	
	public List<Score> retrieveStudentScores(Long id)
	{
		return this.scorerepository.findByStudentId(id);
	}
}
