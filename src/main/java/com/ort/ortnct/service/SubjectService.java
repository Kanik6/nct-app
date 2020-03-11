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
        return subjectRepository.save(subject);

    }

//    public Subject getSubjectByNameAndCategoryFromDBorCreate(Subject subject)
//    {
////        subject.getSubCategory().getSubCategoryName().name()
//       return subjectRepository.findSubjectByNameAndSubCategory(subject.getName())
//               .orElse(createSubjectInDB(subject));
//    }

    public Subject updateSubject(Subject subject)
    {
        Subject subject1 = subjectRepository.findById(subject.getId()).
                map(e ->
                {
                    e.setName(subject.getName());
                    e.setSubCategory(subject.getSubCategory());
                    e.setTest(subject.getTest());
                    return subjectRepository.save(e);
                })
                .orElseGet(() -> {return subjectRepository.save(subject);});
        return subject1;
    }


    public Subject findSubjectByNameAndSubcategory(Subject subject)
    {
        return subjectRepository.findSubjectByNameAndSubCategory(subject.getName(),
                subject.getSubCategory().getSubCategoryName().name()).orElse(null);
    }
}