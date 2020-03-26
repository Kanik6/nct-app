package com.ort.ortnct.dto;

import com.ort.ortnct.entity.Answer;
import com.ort.ortnct.entity.Subject;

import java.util.List;

public class QuestionDto
{
    private Long id;

    private String question;

    private Subject subject;

    private List<Answer> answer;
}
