package com.ort.ortnct.service;

import com.ort.ortnct.entity.*;
import com.ort.ortnct.enums.SubCategories;
import com.ort.ortnct.enums.TestType;
import com.ort.ortnct.controller.SubjectCreationRequestController;
import com.ort.ortnct.exception.NoSuchSubCategoryException;
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
    public Subject addFinalTestORT(SubjectCreationHelper subjectCreationHelper)
    {
        //--------------------------------WRAPPER_HELPER
        Subject subject = subjectCreationHelper.getSubject(); // name , subcategory(BASIC , ADDITIONAL)
        SubCategory subCategory = subjectCreationHelper.getSubCategory();
        Test test = subjectCreationHelper.getTest(); // instruction
        Question question = subjectCreationHelper.getQuestion(); //question
        List<Answer> answers = subjectCreationHelper.getAnswers(); //list answers
        //--------------------------------CREATION IN DB-----------------------------------------

        SubCategory subCategory1 = subCategoryService.getSubCategory(subCategory.getSubCategoryName());
        if((subCategory1.getSubCategoryName().name().equals(SubCategories.ORT_BASIC.name())) || subCategory.getSubCategoryName().name().equals(SubCategories.ORT_ADD.name()))
        {
            subject.setTestType(TestType.FINALTEST);

            subject.setSubCategory(subCategory1);

//         creating subject
            Subject subject1 = subjectService.findSubjectByNameAndSubcategory(subject);
            if(subject1 == null)
            {
                subject1 = subjectService.createSubjectInDB(subject);
                // creating test mapping to subject AND creating in db
                test.setSubject(subject1);
                Test test1 = testService.createTestInDB(test);
                subject1.setTest(test1);
                subjectService.updateSubject(subject1);
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
            // mapping question to test AND creating in db
            question.setTest(subject1.getTest());
            Question question1 = questionService.createQuestionInDB(question);
            // mapping answers to question AND creating in db
            answers.stream().forEach(e -> e.setQuestion(question1));
            List<Answer> answers1 = answerService.createAnswerInDB(answers);
            //-------------------------updating
            // updating test mapping test question
            subject1.getTest().setOneQuestion(question1);
            testService.updateTestInDB(subject1.getTest());
            // updating question mapping question answers
            question1.setAnswer(answers1);
            questionService.updateQuestionInDB(question1);
            return subject1;
        }
        else
        throw new NoSuchSubCategoryException("please specify correct category");
    }

    // adding subject test ORT
    public Subject addSubjectTestORT(SubjectCreationHelper subjectCreationHelper)
    {
        //--------------------------------WRAPPER_HELPER
        Subject subject = subjectCreationHelper.getSubject(); // name , subcategory(BASIC , ADDITIONAL)
        // SubCategory subCategory = subjectCreationHelper.getSubCategory();
        Test test = subjectCreationHelper.getTest(); // instruction
        Question question = subjectCreationHelper.getQuestion(); //question
        List<Answer> answers = subjectCreationHelper.getAnswers(); //list answers
        //--------------------------------CREATION IN DB-----------------------------------------
        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(SubCategories.ORT_SUB);
        SubCategory subCategory1 = subCategoryService.getSubCategory(subCategory.getSubCategoryName());

            subject.setTestType(TestType.SUBJECTTEST);

            subject.setSubCategory(subCategory1);

            //  creating subject
            Subject subject1 = subjectService.findSubjectByNameAndSubcategory(subject);
            if(subject1 == null)
            {
                subject1 = subjectService.createSubjectInDB(subject);
                // creating test mapping to subject AND creating in db
                test.setSubject(subject1);
                Test test1 = testService.createTestInDB(test);
                subject1.setTest(test1);
                subjectService.updateSubject(subject1);
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
            // mapping question to test AND creating in db
            question.setTest(subject1.getTest());
            Question question1 = questionService.createQuestionInDB(question);
            // mapping answers to question AND creating in db
            answers.stream().forEach(e -> e.setQuestion(question1));
            List<Answer> answers1 = answerService.createAnswerInDB(answers);
            //-------------------------updating
            // updating test mapping test question
            subject1.getTest().setOneQuestion(question1);
            testService.updateTestInDB(subject1.getTest());
            // updating question mapping question answers
            question1.setAnswer(answers1);
            questionService.updateQuestionInDB(question1);
            return subject1;

    }
}
