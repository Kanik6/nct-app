//package com.ort.ortnct.util;
//
//import com.ort.ortnct.dto.StaffDto;
//import com.ort.ortnct.dto.SubjectDto;
//import com.ort.ortnct.entity.*;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeMap;
//import org.modelmapper.convention.MatchingStrategies;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class ConverterService
//{
//    @Autowired
//    ModelMapper modelMapper;
//
//    public StaffDto convertToDto(Staff staff)
//    {
//        return modelMapper.map(staff, StaffDto.class);
//    }
//
//    public Staff convertToEntity(StaffDto staffDto)
//    {
//        return modelMapper.map(staffDto, Staff.class);
//    }
//
//    public Subject convertToEnity(SubjectDto subjectDto)
//    {
//
//        Subject subject = modelMapper.map(subjectDto, Subject.class);
//        SubCategory subCategory = modelMapper.map(subjectDto, SubCategory.class);
//        Test test = modelMapper.map(subjectDto, Test.class);
//        Question question = modelMapper.map(subjectDto, Question.class);
//        List<Answer> answers = subjectDto.getAnswers().stream().map(e -> modelMapper.map(e, Answer.class)).collect(Collectors.toList());
//
//        subject.setSubCategory(subCategory);
//        subject.setTest(test);
//        test.setSubject(subject);
//        test.setOneQuestion(question);
//        question.setTest(test);
//        question.setAnswer(answers);
//        answers.stream().forEach(e -> e.setQuestion(question));
//        return subject;
//    }
//
//    //===============================================================================
//}
//
//
