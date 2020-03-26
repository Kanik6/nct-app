package com.ort.ortnct.dto;

import com.ort.ortnct.entity.Answer;

import java.util.List;

public class CreateRequestDto
{
    private Long id;

    private String name;

//    private SubCategory subCategory;
    private String subCategoryName;
//    private Test test;
    private String instruction;

    private String question;

    private List<Answer> answers;

//    private TestType testType;
    private String testType;

    public CreateRequestDto()
    {
    }

    public CreateRequestDto(Long id, String name, String subCategoryName, String instruction,  String question, List<Answer> answers, String testType)
    {
        this.id = id;
        this.name = name;
        this.subCategoryName = subCategoryName;
        this.instruction = instruction;
        this.question = question;
        this.answers = answers;
        this.testType = testType;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSubCategoryName()
    {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName)
    {
        this.subCategoryName = subCategoryName;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public List<Answer> getAnswers()
    {
        return answers;
    }

    public void setAnswers(List<Answer> answers)
    {
        this.answers = answers;
    }

    public String getTestType()
    {
        return testType;
    }

    public void setTestType(String testType)
    {
        this.testType = testType;
    }
}
