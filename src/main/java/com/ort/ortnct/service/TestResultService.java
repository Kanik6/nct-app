package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.entity.TestResultNct;
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
    public TestResultNct createTestResultIndDB(TestResultNct testResultNct)
    {
        Subject subject = subjectService.findSubjectById(testResultNct.getSubjectId());
        testResultNct.setSubject(subject);

        Usr usr = usrService.getUsr1(testResultNct.getUsr_id());
        testResultNct.setUsr(usr);

        TestResultNct testResultNct1 = testResultRepository.findByUser_id(testResultNct.getUsr_id())
                .map(e ->
                {
                    e.setCorrect(testResultNct.getCorrect());
                    e.setIncorrect(testResultNct.getIncorrect());
                    return testResultRepository.save(e);
                })
                .orElseGet(() -> {return testResultRepository.save(testResultNct);});
        return testResultNct1;
    }

    //==========================================READ
    public List<TestResultNct> getListTestResult()
    {
        return testResultRepository.findAll();
    }

    //==========================================UPDATE
    public TestResultNct updateTestResult(TestResultNct testResultNct, Long id)
    {
        TestResultNct testResultNct1 = testResultRepository.findById(id)
                .map(e ->
                {
                    e.setCorrect(testResultNct.getCorrect());
                    e.setIncorrect(testResultNct.getIncorrect());
                    e.setSubject(testResultNct.getSubject());
                    return testResultRepository.save(e);
                })
                .orElseGet(() -> {return testResultRepository.save(testResultNct);});
        return testResultNct1;
    }

    //==========================================DELETE
    public String deleteTestResult(Long id)
    {
        testResultRepository.deleteById(id);
        return "deleted";
    }
}
