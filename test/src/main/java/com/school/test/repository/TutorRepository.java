package com.school.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.test.entity.Tutor;

public interface TutorRepository extends JpaRepository<Tutor,Long>{

}
