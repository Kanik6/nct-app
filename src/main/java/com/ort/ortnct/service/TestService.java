package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.entity.Test;
import com.ort.ortnct.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService
{
    @Autowired
    TestRepository testRepository;

    public Test createTestInDB(Test test)
    {
//        Test test = new Test();
//        test.setSubject(subject);

        return testRepository.save(test);
    }

    public Test updateTestInDB(Test test)
    {
        Test test1 = testRepository.findById(test.getId()).
                map(e ->
                {
                    e.setQuestion(test.getQuestion());
                    e.setSubject(test.getSubject());
                    e.setInstruction(test.getInstruction());
                    e.setQcount(test.getQcount());
                    return testRepository.save(e);
                })
                .orElseGet(() -> {return testRepository.save(test);});
        return test1;
    }
}
