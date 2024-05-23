package com.school.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.test.entity.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice,Long>{

}
