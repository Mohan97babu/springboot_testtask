package com.school.test.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.entity.Tutor;
//import com.school.test.repository.SchoolRepository;
import com.school.test.repository.TutorRepository;

@Service
public class TutorService {

//	@Autowired
//	private SchoolRepository schoolRepo;
	@Autowired
	private TutorRepository tutorRepository;
	
	public Map<String,String> addTutor(final Tutor tutor)
	{	
		Map<String,String> response = new LinkedHashMap<>();
		
			this.tutorRepository.save(tutor);
			response.put("id",tutor.getId()+"");
			response.put("schoolId",tutor.getSchool().getId()+"");
			response.put("schoolName",tutor.getSchool().getName());
			response.put("message","Tutor added Successfully");
		
		return response;
	}
	public List<Tutor> retrieveTutor()
	{
		return this.tutorRepository.findAll();	
	}
}
