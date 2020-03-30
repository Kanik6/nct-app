package com.ort.ortnct.service;

import com.ort.ortnct.entity.TestResultOrt;
import com.ort.ortnct.repository.TestResultOrtRepository;
import com.ort.ortnct.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultOrtService
{
    @Autowired
    TestResultOrtRepository testResultOrtRepository;

    //============================================CREATE

    public TestResultOrt createTestResultOrt(TestResultOrt testResultOrt)
    {
        return testResultOrtRepository.save(testResultOrt);
    }
    //============================================READ

    public List<TestResultOrt> getListTestResultOrt()
    {
        return testResultOrtRepository.findAll();
    }
    //============================================UPDATE

    public TestResultOrt updateTestResultOrtInDB(TestResultOrt testResultOrt)
    {
        TestResultOrt testResultOrt1 = testResultOrtRepository.findById(testResultOrt.getId())
                .map(e ->
                {
                    e.setScore(testResultOrt.getScore());
                    e.setUsr_id(testResultOrt.getUsr_id());
                    return testResultOrtRepository.save(e);
                })
                .orElseGet(() -> {return testResultOrtRepository.save(testResultOrt);});
        return testResultOrt1;
    }
    //============================================DELETE
    public String deleteTestResultOrt(Long id)
    {
        testResultOrtRepository.deleteById(id);
        return "deleted";
    }

}
