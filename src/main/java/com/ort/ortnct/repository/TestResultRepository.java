package com.ort.ortnct.repository;

import com.ort.ortnct.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long>
{

}
