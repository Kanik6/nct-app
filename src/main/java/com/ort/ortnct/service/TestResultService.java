package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.entity.TestResult;
import com.ort.ortnct.entity.Usr;
import com.ort.ortnct.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultService
{
    @Autowired
    TestResultRepository testResultRepository;

    @Autowired
    SubjectService subjectService;

    @Autowired
    UsrService usrService;


    //==========================================CREATE
    public TestResult createTestResultIndDB(TestResult testResult)
    {
        Subject subject = subjectService.findSubjectById(testResult.getSubjectId());
        testResult.setSubject(subject);

        Usr usr = usrService.getUsr1(testResult.getUsr_id());
        testResult.setUsr(usr);

        TestResult testResult1 = testResultRepository.findByUser_id(testResult.getUsr_id())
                .map(e ->
                {
                    e.setScore(testResult.getScore());
                    e.setCorrect(testResult.getCorrect());
                    e.setIncorrect(testResult.getIncorrect());
                    return testResultRepository.save(e);
                })
                .orElseGet(() -> {return testResultRepository.save(testResult);});
        return testResult1;
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
