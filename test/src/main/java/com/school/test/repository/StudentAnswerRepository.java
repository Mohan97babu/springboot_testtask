package com.school.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.test.entity.Question;
import com.school.test.entity.Student;
import com.school.test.entity.StudentAnswer;
import com.school.test.entity.Test;

@Repository
public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Long> {
  
	Optional<StudentAnswer> findByStudentAndQuestionAndTest(Student student, Question question, Test test);
}
