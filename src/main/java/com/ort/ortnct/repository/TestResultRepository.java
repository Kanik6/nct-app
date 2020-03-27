package com.ort.ortnct.repository;

import com.ort.ortnct.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long>
{
    @Query(value = "select * from test_result where user_id = :userId", nativeQuery = true)
    Optional<TestResult> findByUser_id(@Param("userId") String userId);
}
