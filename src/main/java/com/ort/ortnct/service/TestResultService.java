package com.ort.ortnct.service;

import com.ort.ortnct.entity.TestResult;
import com.ort.ortnct.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultService
{
    @Autowired
    TestResultRepository testResultRepository;


    //==========================================CREATE
    public TestResult createTestResultIndDB(TestResult testResult)
    {
        return testResultRepository.save(testResult);
    }

    //==========================================READ
    public List<TestResult> getListTestResult()
    {
        return testResultRepository.findAll();
    }

    //==========================================UPDATE
    public TestResult updateTestResult(TestResult testResult, Long id)
    {
        TestResult testResult1 = testResultRepository.findById(id)
                .map(e ->
                {
                    e.setScore(testResult.getScore());
                    e.setCorrect(testResult.getCorrect());
                    e.setIncorrect(testResult.getIncorrect());
                    e.setSubject(testResult.getSubject());
                    return testResultRepository.save(e);
                })
                .orElseGet(() -> {return testResultRepository.save(testResult);});
        return testResult1;
    }

    //==========================================DELETE
    public String deleteTestResult(Long id)
    {
        testResultRepository.deleteById(id);
        return "deleted";
    }
}
