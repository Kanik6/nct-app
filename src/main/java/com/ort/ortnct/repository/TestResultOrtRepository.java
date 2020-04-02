package com.ort.ortnct.repository;

import com.ort.ortnct.entity.TestResultNct;
import com.ort.ortnct.entity.TestResultOrt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestResultOrtRepository extends JpaRepository<TestResultOrt, Long>
{
    @Query(value = "select * from test_result_ort where user_id = :userId", nativeQuery = true)
    Optional<TestResultOrt> findByUser_id(@Param("userId") String userId);
}
