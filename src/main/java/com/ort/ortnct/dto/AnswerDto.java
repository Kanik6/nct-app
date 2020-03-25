package com.ort.ortnct.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ort.ortnct.entity.Question;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class AnswerDto
{
    private Long id;

    private String answer;

    private Boolean isCorrect;

    private Question question;
}
