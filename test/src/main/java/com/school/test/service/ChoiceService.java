package com.school.test.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponseDTO;
import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.Choice;
import com.school.test.repository.ChoiceRepository;

@Service
public class ChoiceService {

	@Autowired
	private ChoiceRepository choicerepository;

	public ResponsePostDTO addChoice(final Choice choice) {
		this.choicerepository.save(choice);

		ResponsePostDTO temp = new ResponsePostDTO();
		temp.setId(choice.getId());
		temp.setMessage("Choice Added Successfully");

		return temp;
	}

	public List<ResponseDTO> retrieveChoice(final long id) {

		List<Choice> data = this.choicerepository.findByQuestionId(id);
		List<ResponseDTO> resList = new ArrayList<ResponseDTO>();

		for (Choice choice : data) {
			ResponseDTO temp = new ResponseDTO();
			temp.setId(choice.getId());
			temp.setChoice(choice.getChoice());
			resList.add(temp);
		}

		return resList;
	}
}
