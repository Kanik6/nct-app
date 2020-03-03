package com.ort.ortnct.service;

import com.ort.ortnct.entity.*;
import com.ort.ortnct.enums.TestType;
import com.ort.ortnct.controller.SubjectCreationRequestController;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectCreationRequestService
{
    @Autowired
    SubjectCreationRequestController subjectCreationRequestController;

    @Autowired
    SubjectService subjectService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    SubCategoryService subCategoryService;

    // adding final test ORT
    public Subject fillSubject(SubjectCreationHelper subjectCreationHelper)
    {
        Subject subject = subjectCreationHelper.getSubject();// name , subcategory(BASIC , ADDITIONAL)
        Test test = subjectCreationHelper.getTest();// instruction
        Question question = subjectCreationHelper.getQuestion();//question
        List<Answer> answers = subjectCreationHelper.getAnswers();//list answers
        //--------------------------------CREATION IN DB-----------------------------------------
        subject.setTestType(TestType.FINALTEST);
        SubCategory subCategory = subCategoryService.getSubCategory(subject.getSubCategory().getSubCategoryName());
        subject.setSubCategory(subCategory);
        Subject subject1 = subjectService.createSubjectInDB(subject);

        Test test1 = subject1.getTest();
        test1.setInstruction(test.getInstruction());
//        question.setTest(test1);
        Question question1 = questionService.createQuestionInDB(question);
        List<Answer> answers1 = answerService.createAnswerInDB(answers);
        question1.setTest(test1);
        question1.setAnswer(answers1);
        //------------------------------
        System.out.println(question1.getTest().getId());
        //------------------------------
        test1.setOneQuestion(question1);
//        subject1.setTest(test1);

        return subjectService.createSubjectInDB(subject1);
    }
}
