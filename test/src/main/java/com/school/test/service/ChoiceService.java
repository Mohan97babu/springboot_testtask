package com.school.test.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.test.dto.ResponseDTO;
import com.school.test.dto.ResponsePostDTO;
import com.school.test.entity.Choice;
import com.school.test.entity.Question;
import com.school.test.repository.ChoiceRepository;
import com.school.test.repository.QuestionRepository;


@Service
public class ChoiceService {
  
	@Autowired
	ChoiceRepository choicerepository;
	
	@Autowired
	QuestionRepository questionrepository;
	
	public ResponsePostDTO addChoice(final Choice choice)
	{
//		Map<String,String> response = new LinkedHashMap<>();
		this.choicerepository.save(choice);
//		response.put("id", choice.getId()+"");
//		response.put("questionId",choice.getQuestion().getId()+"");
//	    response.put("message", "choice added successfully");

		ResponsePostDTO temp = new ResponsePostDTO();
		temp.setId(choice.getId());
		temp.setMessage("Choice Added Successfully");
		
		return temp;
	} 
	public List<ResponseDTO> retrieveChoice(final long id)
	{
//		List<Question> = this.questionrepository.findById(id);
		List<Choice> data = this.choicerepository.findByQuestionId(id);
		List<ResponseDTO> resList = new ArrayList<ResponseDTO>();
		for(Choice choice : data)
		{
			ResponseDTO temp = new ResponseDTO();
			temp.setId(choice.getId());
			temp.setChoice(choice.getChoice());
//			temp.setMessage(null);
			resList.add(temp);
		}		
		return resList;
	}
}
