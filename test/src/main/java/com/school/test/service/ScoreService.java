package com.school.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponseScoreDTO;
import com.school.test.entity.Score;
import com.school.test.repository.ScoreRepository;

@Service
public class ScoreService {

	@Autowired
	private ScoreRepository scorerepository;

	public List<ResponseScoreDTO> retrieveScore() {
		List<Score> data = this.scorerepository.findAll();
		List<ResponseScoreDTO> resList = new ArrayList<>();
		for (Score score : data) {
			ResponseScoreDTO temp = new ResponseScoreDTO();
			temp.setScoreId(score.getId());
			temp.setStudentId(score.getStudent().getId() + "");
			temp.setTutorId(score.getTest().getId() + "");
			temp.setMessage(score.getTest().getTestName() + " test is conducted in " + score.getTest().getTestDate());
			temp.setScore(score.getScore() + "");
			resList.add(temp);
		}
		return resList;
	}

	public List<ResponseScoreDTO> retrieveStudentScores(Long id) {
		List<Score> data = this.scorerepository.findByStudentId(id);
		List<ResponseScoreDTO> resList = new ArrayList<>();
		for (Score score : data) {
			ResponseScoreDTO temp = new ResponseScoreDTO();
			temp.setScoreId(score.getId());
			temp.setStudentId(score.getStudent().getId() + "");
			temp.setTutorId(score.getTest().getId() + "");
			temp.setMessage(score.getTest().getTestName() + " test is conducted in " + score.getTest().getTestDate());
			temp.setScore(score.getScore() + "");
			resList.add(temp);
		}

		return resList;
	}
}
