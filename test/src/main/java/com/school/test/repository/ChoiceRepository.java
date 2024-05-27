package com.school.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.school.test.entity.Choice;
import com.school.test.entity.Question;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice,Long>{

	List<Choice> findByQuestionId(long id);
}
