package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tests")
@ApiModel(value = "test model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Test
{
    @Column(name = "test_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "test_name")
    private String name;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "question_count")
    private Long qcount;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "subject_name")
    private String subjectName;

    @OneToMany(mappedBy = "test")
    private List<Question> question = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "test")
    private List<TestResult> testResult;

    public Test()
    {
    }

    public Test(String name, String instruction, Long qcount, String subjectName)
    {
        this.name = name;
        this.instruction = instruction;
        this.qcount = qcount;
        this.subjectName = subjectName;
    }

    public Long getId()
    {
        return id;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setInstruction(String instruction)
    {
        this.instruction = instruction;
    }

    public Long getQcount()
    {
        return qcount;
    }

    public void setQcount(Long qcount)
    {
        this.qcount = qcount;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
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

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }

    public List<TestResult> getTestResult()
    {
        return testResult;
    }

    public void setTestResult(List<TestResult> testResult)
    {
        this.testResult = testResult;
    }

    @Override
    public String toString()
    {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruction='" + instruction + '\'' +
                ", qcount=" + qcount +
                ", subject=" + subject +
                ", subjectName='" + subjectName + '\'' +
                ", question=" + question +
                ", testResult=" + testResult +
                '}';
    }
}
