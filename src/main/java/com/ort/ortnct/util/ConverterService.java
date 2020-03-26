package com.ort.ortnct.util;

import com.ort.ortnct.dto.CreateRequestDto;
import com.ort.ortnct.dto.StaffDto;
import com.ort.ortnct.entity.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConverterService
{
    @Autowired
    ModelMapper modelMapper;
    //---------------Staff
    public StaffDto convertToDto(Staff staff)
    {
        return modelMapper.map(staff, StaffDto.class);
    }

    public Staff convertToEntity(StaffDto staffDto)
    {
        return modelMapper.map(staffDto, Staff.class);
    }
    //---------------Staff


    public Subject convertToEntity(CreateRequestDto subjectDto)
    {
        Subject subject = modelMapper.map(subjectDto, Subject.class);
        SubCategory subCategory = modelMapper.map(subjectDto, SubCategory.class);
        Question question = modelMapper.map(subjectDto, Question.class);
        List<Answer> answers = subjectDto.getAnswers().stream().map(e -> modelMapper.map(e, Answer.class)).collect(Collectors.toList());

        subject.setSubCategory(subCategory);
//        subject.setTest(test);
//
//        question.setTest(test);
        question.setAnswer(answers);
        answers.forEach(e -> e.setQuestion(question));
        return subject;
    }

    //===============================================================================
}


