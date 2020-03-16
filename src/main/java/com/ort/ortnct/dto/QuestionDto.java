package com.ort.ortnct.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ort.ortnct.entity.Answer;
import com.ort.ortnct.entity.Test;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class QuestionDto
{
    private Long id;

    private String question;

    private Test test;

    private List<Answer> answer;
}
