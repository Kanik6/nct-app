package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ort.ortnct.enums.TestType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subjects")
@ApiModel(value = "subject model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Subject
{
    @Column(name = "subject_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 0)
    private Long id;

    @Column(name = "subject_name")
    @NotBlank(message = "subject name is mandatory!")
    @ApiModelProperty(position = 1)
    private String name;

    @Column(name = "instruction")
    private String instruction;

    @OneToMany(mappedBy = "subject")
    private List<Question> question = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<TestResult> testResult;

    @Column(name = "creation_date")
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "subject_sub_category",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    @ApiModelProperty(position = 2)
    @JsonIgnore
    private SubCategory subCategory;

    @Column(name = "test_type")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(position = 4)
    @JsonIgnore
    private TestType testType;

    public Subject()
    {
    }

    public Subject(String name, SubCategory subCategory, String instruction)
    {
        this.name = name;
        this.subCategory = subCategory;
        this.instruction = instruction;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public SubCategory getSubCategory()
    {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory)
    {
        this.subCategory = subCategory;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public LocalDate getCreationDate()
    {
        return creationDate;
    }

    public List<Question> getQuestion()
    {
        return question;
    }

    public void setQuestion(List<Question> question)
    {
        this.question = question;
    }

    public void setOneQuestion(Question question)
    {
        this.question.add(question);
    }

    public List<TestResult> getTestResult()
    {
        return testResult;
    }

    public void setTestResult(List<TestResult> testResult)
    {
        this.testResult = testResult;
    }

    public TestType getTestType()
    {
        return testType;
    }

    public void setTestType(TestType testType)
    {
        this.testType = testType;
    }

    @Override
    public String toString()
    {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruction='" + instruction + '\'' +
                ", question=" + question +
                ", testResult=" + testResult +
                ", creationDate=" + creationDate +
                ", subCategory=" + subCategory +
                ", testType=" + testType +
                '}';
    }
}
