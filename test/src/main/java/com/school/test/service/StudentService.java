package com.school.test.service;


import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.school.test.dto.PaginatedResponseDTO;
import com.school.test.dto.ResponsePostDTO;
import com.school.test.dto.SearchRequestDTO;
import com.school.test.entity.Student;
import com.school.test.repository.StudentRepository;

@Service
public class StudentService {
   
	@Autowired
	private StudentRepository studentrespository;

	
	public ResponsePostDTO addStudent(final Student student) throws AccountNotFoundException
	{
		Student savedStudent = this.studentrespository.save(student);

		ResponsePostDTO response = new ResponsePostDTO();
		response.setId(savedStudent.getId());
		response.setMessage("Student is added successfully");
		return response;
	}
	
	public PaginatedResponseDTO<Student> retrieveStudent(int page,int size)
	{
		Page<Student> studentPage = this.studentrespository.findAll(PageRequest.of(page,size));
		
		PaginatedResponseDTO<Student> response = new PaginatedResponseDTO<>();
		response.setData(studentPage.getContent());
		response.setPageNumber(studentPage.getNumber());
		response.setTotalElements(studentPage.getTotalElements());
		response.setTotalPages(studentPage.getTotalPages());
		response.setPageSize(studentPage.getSize());
		return response;
	}
	public PaginatedResponseDTO<Student> searchStudents(SearchRequestDTO request)
	{
		Page<Student> studentPage = studentrespository.searchStudents(
				request.getFirstName(),
				request.getLastName(),
				request.getId(),
				PageRequest.of(request.getPage(), request.getSize()));
		
		PaginatedResponseDTO<Student> response = new PaginatedResponseDTO<>();
		response.setData(studentPage.getContent());
		response.setPageNumber(studentPage.getNumber());
		response.setTotalElements(studentPage.getTotalElements());
		response.setTotalPages(studentPage.getTotalPages());
		response.setPageSize(studentPage.getSize());
		return response;
	}
}
