package com.ort.ortnct.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ort.ortnct.entity.Question;
import com.ort.ortnct.entity.Subject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TestDto
{
    private Long id;

    private String instruction;

    private Long qcount;

    private Subject subject;

    private List<Question> question = new ArrayList<>();
}
