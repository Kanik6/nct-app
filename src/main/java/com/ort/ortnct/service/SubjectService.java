package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.entity.Test;
import com.ort.ortnct.exception.NoSubjectsFoundException;
import com.ort.ortnct.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    //=============================================
    public List<Subject> getListSubjectOrtBasic()
    {
        return subjectRepository.findAllOrtFinalBasicSubjects().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));
    }

    public List<Subject> getListSubjectOrtAdd()
    {
        return subjectRepository.findAllOrtFinalAddSubjects().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));
    }

    public List<Subject> getListSubjectOrt()
    {
        return subjectRepository.findAllOrtSubjects().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));
    }
    //=============================================
    public Subject findSubjectByNameAndSubcategory(Subject subject)
    {
        return subjectRepository.findSubjectByNameAndSubCategory(subject.getName(),
                subject.getSubCategory().getSubCategoryName().name()).orElse(null);
    }
}
