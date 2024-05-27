package com.school.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.test.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{
  
	
}
