package com.school.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.test.entity.StudentAnswer;

@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> {

}
