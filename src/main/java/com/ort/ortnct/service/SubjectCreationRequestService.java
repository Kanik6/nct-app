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
        // mapping question to test
        question.setTest(test1);
        Question question1 = questionService.createQuestionInDB(question);
        // mapping answers to question
        answers.stream().forEach(e -> e.setQuestion(question1));
        answerService.createAnswerInDB(answers);

        return subject1;
    }
}
