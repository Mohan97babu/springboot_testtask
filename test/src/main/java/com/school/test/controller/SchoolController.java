package com.school.test.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.test.dto.PaginatedRequestDTO;
import com.school.test.dto.PaginatedResponseDTO;
import com.school.test.dto.SearchRequestDTO;
import com.school.test.entity.School;
import com.school.test.service.SchoolService;

@RestController
@RequestMapping("/api/v1")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolservice;
	
	@PostMapping("/school")
    public School createSchool(@RequestBody School school)
    {
	   return this.schoolservice.createSchool(school);
    }	
//	@GetMapping("/school")
//	public List<School> retrieveSchool()
//	{
//		return this.schoolservice.retrieveSchool();
//	}
	@GetMapping("/school")
	public PaginatedResponseDTO<School> retrieveSchool(PaginatedRequestDTO request)
	{
		return this.schoolservice.getSchools(request);
	}
//	@GetMapping("/school/search")
//	public PaginatedResponseDTO<School> retrieveSchoolWithName(PaginatedRequestDTO request)
//	{
//		return this.schoolservice.getSchoolsWithName(request);
//	}
	 @GetMapping("/schools/search")
	    public PaginatedResponseDTO<School> searchSchools(@ModelAttribute SearchRequestDTO searchRequest) {
	        return schoolservice.searchSchools(searchRequest);
	    }
//	 @GetMapping("/schools/search")
//	    public PaginatedResponseDTO<School> searchSchoolsWithOrder(@ModelAttribute SearchRequestDTO searchRequest,Sort sort) {
//	        return schoolservice.searchSchoolsWithOrder(searchRequest,sort);
//	    }
	 @GetMapping("/schools/search/sort")
	  public PaginatedResponseDTO<School> searchSchoolsWithOrder(@ModelAttribute SearchRequestDTO searchRequestWithOrder, Sort sort) {

//	    System.out.println(searchRequestWithOrder.getSortOrder().toString().getClass());
	    if (searchRequestWithOrder.getSortField() == null || searchRequestWithOrder.getSortOrder() == null) {
	      sort = Sort.by(Sort.Direction.ASC, "name");
	    } else {
	        if (searchRequestWithOrder.getSortOrder().toString().equals("DESC")) {
	          sort = Sort.by( Sort.Direction.DESC,searchRequestWithOrder.getSortField());
	        } else {
	          sort = Sort.by(Sort.Direction.ASC,searchRequestWithOrder.getSortField());
	        }
	    }

	    return schoolservice.searchSchoolsWithOrder(searchRequestWithOrder, sort);
	  }}
