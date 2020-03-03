package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.entity.Test;
import com.ort.ortnct.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService
{
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TestService testService;

    public Subject createSubjectInDB(Subject subject)
    {
        Subject subject1 = subjectRepository.save(subject);
        Test test = testService.createTestInDB(subject1);
        subject1.setTest(test);

        return subject1;

    }
}
