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

    @Autowired
    TestService testService;

    // adding final test ORT
    public Subject fillSubject(SubjectCreationHelper subjectCreationHelper)
    {
        //--------------------------------WRAPPER_HELPER
        Subject subject = subjectCreationHelper.getSubject(); // name , subcategory(BASIC , ADDITIONAL)
        Test test = subjectCreationHelper.getTest(); // instruction
        Question question = subjectCreationHelper.getQuestion(); //question
        List<Answer> answers = subjectCreationHelper.getAnswers(); //list answers
        //--------------------------------CREATION IN DB-----------------------------------------
        subject.setTestType(TestType.FINALTEST);
        SubCategory subCategory = subCategoryService.getSubCategory(subject.getSubCategory().getSubCategoryName());
        subject.setSubCategory(subCategory);

//         creating subject
        Subject subject1 = subjectService.createSubjectInDB(subject);
        // creating test mapping to subject AND creating in db
        test.setSubject(subject1);
        Test test1 = testService.createTestInDB(test);
        // mapping question to test AND creating in db
        question.setTest(test1);
        Question question1 = questionService.createQuestionInDB(question);
        // mapping answers to question AND creating in db
        answers.stream().forEach(e -> e.setQuestion(question1));
        List<Answer> answers1 = answerService.createAnswerInDB(answers);
        //-------------------------updating
        // updating subject mapping to test
        subject1.setTest(test1);
        Subject subject2 = subjectService.updateSubject(subject1);
        // updating test mapping test question
        test1.setOneQuestion(question1);
        testService.updateTestInDB(test1);
        // updating question mapping question answers
        question1.setAnswer(answers1);
        questionService.updateQuestionInDB(question1);
        return subject2;
    }
}
