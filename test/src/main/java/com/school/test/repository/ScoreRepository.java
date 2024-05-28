package com.school.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.school.test.entity.Score;
import com.school.test.entity.Student;
import com.school.test.entity.Test;

public interface ScoreRepository extends JpaRepository<Score, Long> {

	Optional<Score> findByStudentAndTest(Student student, Test test);

	@Query("SELECT s FROM Score s WHERE s.test.tutor.id = :tutorId")
	List<Score> findScoresByTutorId(@Param("tutorId") long tutorId);

	List<Score> findByStudentId(long studentId);
}
