package com.school.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.test.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test,Long> {

}
