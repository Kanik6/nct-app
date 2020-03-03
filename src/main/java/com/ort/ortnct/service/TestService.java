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

    public Test createTestInDB(Subject subject)
    {
        Test test = new Test();
        test.setSubject(subject);

        return testRepository.save(test);
    }
}
