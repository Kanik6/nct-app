package com.ort.ortnct.service;

import com.ort.ortnct.entity.Answer;
import com.ort.ortnct.entity.Question;
import com.ort.ortnct.entity.Subject;
import com.ort.ortnct.exception.NoSuchSubCategoryException;
import com.ort.ortnct.myHelper.SubjectCreationHelper;
import com.ort.ortnct.util.ConverterService;
import com.ort.ortnct.util.ConvertoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SubjectCreationRequestService
{
    @Autowired
    SubjectService subjectService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerService answerService;

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    ConverterService converterService;

    @Autowired
    ConvertoBase convertoBase;

    // adding final test ORT
    public Subject addFinalTestORT(SubjectCreationHelper subjectCreationHelper, MultipartFile qImage, MultipartFile[] aImage)
    {
        //--------------------------------WRAPPER_HELPER
        Subject subject = subjectCreationHelper.getSubject(); // name , subcategory(BASIC , ADDITIONAL)
        SubCategory subCategory = subjectCreationHelper.getSubCategory();
        Question question = subjectCreationHelper.getQuestion(); //question
        String qBase64Image = convertoBase.convertToBase64(qImage);
        question.setImage(qBase64Image);
        List<Answer> answers = subjectCreationHelper.getAnswers(); //list answers
        for(int i = 0; i < aImage.length; i++)
        {
            String aBase64Image = convertoBase.convertToBase64(aImage[i]);
            answers.get(i).setImage(aBase64Image);
        }

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
                // mapping question to test AND creating in db
                question.setSubject(subject1);
                Question question1 = questionService.createQuestionInDB(question);
                // mapping answers to question AND creating in db
                answers.stream().forEach(e -> e.setQuestion(question1));
                List<Answer> answers1 = answerService.createAnswerInDB(answers);
                //-------------------------updating
                // updating subject mapping to test
                subject1.setOneQuestion(question1);
                Subject subject2 = subjectService.updateSubject(subject1);
                // updating test mapping test question
                // updating question mapping question answers
                question1.setAnswer(answers1);

//                question1.setCorrectAnswer(answers1.stream().filter(e -> e.getCorrect() == true).findFirst().get());
                questionService.updateQuestionInDB(question1);
                return subject2;

            }
            // mapping question to test AND creating in db
            question.setSubject(subject1);
            Question question1 = questionService.createQuestionInDB(question);
            // mapping answers to question AND creating in db
            answers.stream().forEach(e -> e.setQuestion(question1));
            List<Answer> answers1 = answerService.createAnswerInDB(answers);
            //-------------------------updating
            // updating test mapping test question
            subject1.setOneQuestion(question1);
            subjectService.updateSubject(subject1);
            // updating question mapping question answers
            question1.setAnswer(answers1);
//            question1.setCorrectAnswer(answers1.stream().filter(e -> e.getCorrect() == true).findFirst().get());
            questionService.updateQuestionInDB(question1);
            return subject1;
        }
        else
        throw new NoSuchSubCategoryException("please specify correct category");
    }

    // adding subject test ORT
    public Subject addSubjectTestORT(SubjectCreationHelper subjectCreationHelper, MultipartFile qImage, MultipartFile[] aImage)
    {
        //--------------------------------WRAPPER_HELPER
        Subject subject = subjectCreationHelper.getSubject(); // name , subcategory(BASIC , ADDITIONAL)
        // SubCategory subCategory = subjectCreationHelper.getSubCategory();
        Question question = subjectCreationHelper.getQuestion(); //question
        String qBase64Image = convertoBase.convertToBase64(qImage);
        question.setImage(qBase64Image);
        List<Answer> answers = subjectCreationHelper.getAnswers(); //list answers
        for(int i = 0; i < aImage.length; i++)
        {
            String aBase64Image = convertoBase.convertToBase64(aImage[i]);
            answers.get(i).setImage(aBase64Image);
        }

//        question.setImage(qBase64Image);

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
                // mapping question to test AND creating in db
                question.setSubject(subject1);
                Question question1 = questionService.createQuestionInDB(question);
                // mapping answers to question AND creating in db
                answers.stream().forEach(e -> e.setQuestion(question1));
                List<Answer> answers1 = answerService.createAnswerInDB(answers);
                //-------------------------updating
                // updating subject mapping to test
                // updating test mapping test question
                subject1.setOneQuestion(question1);
                Subject subject2 = subjectService.updateSubject(subject1);
                // updating question mapping question answers
                question1.setAnswer(answers1);
//                question1.setCorrectAnswer(answers1.stream().filter(e -> e.getCorrect() == true).findFirst().get());
                questionService.updateQuestionInDB(question1);
                return subject2;

            }
            // mapping question to test AND creating in db
            question.setSubject(subject1);
            Question question1 = questionService.createQuestionInDB(question);
            // mapping answers to question AND creating in db
            answers.stream().forEach(e -> e.setQuestion(question1));
            List<Answer> answers1 = answerService.createAnswerInDB(answers);
            //-------------------------updating
            // updating test mapping test question
            subject1.setOneQuestion(question1);
            Subject subject2 = subjectService.updateSubject(subject1);
            // updating question mapping question answers
            question1.setAnswer(answers1);
//            question1.setCorrectAnswer(answers1.stream().filter(e -> e.getCorrect() == true).findFirst().get());
            questionService.updateQuestionInDB(question1);
            return subject2;

    }

    // adding subject test NCT
    public Subject addSubjectTestNCT(SubjectCreationHelper subjectCreationHelper, MultipartFile qImage,
                                     MultipartFile[] aImage) throws IOException
    {
        //--------------------------------WRAPPER_HELPER
        Subject subject = subjectCreationHelper.getSubject(); // name , subcategory(BASIC , ADDITIONAL)
        SubCategory subCategory = subjectCreationHelper.getSubCategory();
        Question question = subjectCreationHelper.getQuestion(); //question
        String qBase64Image = convertoBase.convertToBase64(qImage);
        question.setImage(qBase64Image);
        List<Answer> answers = subjectCreationHelper.getAnswers(); //list answers
        for(int i = 0; i < aImage.length; i++)
        {
            String aBase64Image = convertoBase.convertToBase64(aImage[i]);
            answers.get(i).setImage(aBase64Image);
        }
//
//        question.setImage(qBase64Image);
        //--------------------------------CREATION IN DB-----------------------------------------

        SubCategory subCategory1 = subCategoryService.getSubCategory(subCategory.getSubCategoryName());
        if((subCategory1.getSubCategoryName().name().equals(SubCategories.NCT_GRADE5.name()))
                || subCategory.getSubCategoryName().name().equals(SubCategories.NCT_GRADE6.name())
                || subCategory.getSubCategoryName().name().equals(SubCategories.NCT_GRADE7.name())
                || subCategory.getSubCategoryName().name().equals(SubCategories.NCT_GRADE8.name())
                || subCategory.getSubCategoryName().name().equals(SubCategories.NCT_GRADE9.name())
                || subCategory.getSubCategoryName().name().equals(SubCategories.NCT_GRADE10.name())
                || subCategory.getSubCategoryName().name().equals(SubCategories.NCT_GRADE11.name())
          )
        {
            subject.setTestType(TestType.SUBJECTTEST);

            subject.setSubCategory(subCategory1);

//         creating subject
            Subject subject1 = subjectService.findSubjectByNameAndSubcategory(subject);
            if(subject1 == null)
            {
                subject1 = subjectService.createSubjectInDB(subject);
                // creating test mapping to subject AND creating in db
                // mapping question to test AND creating in db
//                arrayQuestion.stream.forEach(e -> e.setSubject(subject1))
//                List<Question> arrayQuestion = questionService.createArrQuestion(arrayQuestion);
//                arrayQuestion
                question.setSubject(subject1);
                Question question1 = questionService.createQuestionInDB(question);
                // mapping answers to question AND creating in db
                answers.stream().forEach(e -> e.setQuestion(question1));
                List<Answer> answers1 = answerService.createAnswerInDB(answers);
                //-------------------------updating
                // updating subject mapping to test
                subject1.setOneQuestion(question1);
                Subject subject2 = subjectService.updateSubject(subject1);
                // updating test mapping test question
                // updating question mapping question answers
                question1.setAnswer(answers1);

//                question1.setCorrectAnswer(answers1.stream().filter(e -> e.getCorrect() == true).findFirst().get());
                questionService.updateQuestionInDB(question1);
                return subject2;

            }
            // mapping question to test AND creating in db
            question.setSubject(subject1);
            Question question1 = questionService.createQuestionInDB(question);
            // mapping answers to question AND creating in db
            answers.stream().forEach(e -> e.setQuestion(question1));
            List<Answer> answers1 = answerService.createAnswerInDB(answers);
            //-------------------------updating
            // updating test mapping test question
            subject1.setOneQuestion(question1);
            subjectService.updateSubject(subject1);
            // updating question mapping question answers
            question1.setAnswer(answers1);
//            question1.setCorrectAnswer(answers1.stream().filter(e -> e.getCorrect() == true).findFirst().get());
            questionService.updateQuestionInDB(question1);
            return subject1;
        }
        else
            throw new NoSuchSubCategoryException("please specify correct category");
    }

    //========================================MAPPER ORT FINAL
//    public Subject addFinalTestORTMAPPER(CreateRequestDto createRequestDto)
//    {
//        Subject subject = converterService.convertToEntity(createRequestDto);
////        List<Object> requestObj = converterService.convertToEntity(createRequestDto);
//         //--------------------------------WRAPPER_HELPER
//         // name , subcategory(BASIC , ADDITIONAL)
//        SubCategory subCategory = subject.getSubCategory();
//        Test test = subject.getTest(); // instruction
//        Question question = subject.getTest().getQuestion().stream().findFirst().get();
//        List<Answer> answers = question.getAnswer(); //list answers
//        //--------------------------------CREATION IN DB-----------------------------------------
//
//        SubCategory subCategory1 = subCategoryService.getSubCategory(subCategory.getSubCategoryName());
//        if((subCategory1.getSubCategoryName().name().equals(SubCategories.ORT_BASIC.name())) || subCategory.getSubCategoryName().name().equals(SubCategories.ORT_ADD.name()))
//        {
//            subject.setTestType(TestType.FINALTEST);
//
//            subject.setSubCategory(subCategory1);
//
////         creating subject
//            Subject subject1 = subjectService.findSubjectByNameAndSubcategory(subject);
//            if(subject1 == null)
//            {
//                subject1 = subjectService.createSubjectInDB(subject);
//                // creating test mapping to subject AND creating in db
//                test.setSubject(subject1);
//                Test test1 = testService.createTestInDB(test);
//                subject1.setTest(test1);
//                subjectService.updateSubject(subject1);
//                // mapping question to test AND creating in db
//                question.setTest(test1);
//                Question question1 = questionService.createQuestionInDB(question);
//                // mapping answers to question AND creating in db
//                answers.forEach(e -> e.setQuestion(question1));
//                List<Answer> answers1 = answerService.createAnswerInDB(answers);
//                        //-------------------------updating
//                // updating subject mapping to test
//                subject1.setTest(test1);
//                Subject subject2 = subjectService.updateSubject(subject1);
//                // updating test mapping test question
//                test1.setOneQuestion(question1);
//                testService.updateTestInDB(test1);
//                // updating question mapping question answers
//                question1.setAnswer(answers1);
//                questionService.updateQuestionInDB(question1);
//                return subject2;
//
//            }
//            // mapping question to test AND creating in db
//            question.setTest(subject1.getTest());
//            Question question1 = questionService.createQuestionInDB(question);
//            // mapping answers to question AND creating in db
//            answers.forEach(e -> e.setQuestion(question1));
//
//            List<Answer> answers1 = answerService.createAnswerInDB(answers);
//            //-------------------------updating
//            // updating test mapping test question
//            subject1.getTest().setOneQuestion(question1);
//            testService.updateTestInDB(subject1.getTest());
//            // updating question mapping question answers
//            question1.setAnswer(answers1);
//            questionService.updateQuestionInDB(question1);
//            return subject1;
//        }
//        else
//            throw new NoSuchSubCategoryException("please specify correct category");
//    }
}
