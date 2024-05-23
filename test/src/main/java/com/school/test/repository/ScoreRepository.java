package com.school.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.test.entity.Score;
import com.school.test.entity.Student;
import com.school.test.entity.Test;

public interface ScoreRepository extends JpaRepository<Score,Long>{

	Optional<Score> findByStudentAndTest(Student student, Test test);

}
