package com.school.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.Score;
import com.school.test.entity.Tutor;
import com.school.test.repository.ScoreRepository;
import com.school.test.repository.TutorRepository;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private ScoreRepository scoreRepository;

	public ResponsePostDTO addTutor(final Tutor tutor) {


		this.tutorRepository.save(tutor);

		ResponsePostDTO response = new ResponsePostDTO();
		response.setId(tutor.getId());
		response.setMessage("Tutor is added successfully");
		return response;
	}

	public List<Tutor> retrieveTutor() {
		return this.tutorRepository.findAll();
	}

	public List<Score> getStudentScoresUnderTutor(long tutorId) {
		return this.scoreRepository.findScoresByTutorId(tutorId);
	}
}
