package com.ort.ortnct.controller;

import com.ort.ortnct.entity.Question;
import com.ort.ortnct.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    @PostMapping("/testQuestion")
    public Question createQuestionwithImage(@RequestPart Question question, @RequestPart MultipartFile image)
    {
        return questionService.createQuestionInDBtest(question, image);
    }
}
