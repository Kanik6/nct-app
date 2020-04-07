package com.ort.ortnct.service;

import com.ort.ortnct.entity.Subject;
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
                    e.setInstruction(subject.getInstruction());
                    return subjectRepository.save(e);
                })
                .orElseGet(() -> {return subjectRepository.save(subject);});
        return subject1;
    }
    //=============================================ORT
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
    //=============================================NCT
    public List<Subject> getListSubjectNct5()
    {
        return subjectRepository.findAllNctSubjectsGrade5().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    public List<Subject> getListSubjectNct6()
    {
        return subjectRepository.findAllNctSubjectsGrade6().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    public List<Subject> getListSubjectNct7()
    {
        return subjectRepository.findAllNctSubjectsGrade7().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    public List<Subject> getListSubjectNct8()
    {
        return subjectRepository.findAllNctSubjectsGrade8().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    public List<Subject> getListSubjectNct9()
    {
        return subjectRepository.findAllNctSubjectsGrade9().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    public List<Subject> getListSubjectNct10()
    {
        return subjectRepository.findAllNctSubjectsGrade10().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    public List<Subject> getListSubjectNct11()
    {
        return subjectRepository.findAllNctSubjectsGrade11().orElseThrow(() -> new NoSubjectsFoundException("No subjects found!"));

    }

    //=============================================
    public Subject findSubjectById(Long id)
    {
        return subjectRepository.findById(id).orElseThrow(() -> new NoSubjectsFoundException("No such subject!"));
    }

    public Subject findSubjectByNameAndSubcategory(Subject subject)
    {
        return subjectRepository.findSubjectByNameAndSubCategory(subject.getName(),
                subject.getSubCategory().getSubCategoryName().name()).orElse(null);
    }
}
