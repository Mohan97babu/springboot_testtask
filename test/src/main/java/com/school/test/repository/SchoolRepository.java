package com.school.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.test.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long>{
	
}
