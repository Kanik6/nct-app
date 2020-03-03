package com.ort.ortnct.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tests")
@ApiModel(value = "test model")
public class Test
{
    @Column(name = "test_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "question_count")
    private Long qcount;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToMany(mappedBy = "test")
    private List<Question> question;

    public Test()
    {
    }

    public Test(String instruction, Long qcount)
    {
        this.instruction = instruction;
        this.qcount = qcount;
        this.subject = subject;
    }

    public Long getId()
    {
        return id;
    }

    public String getInstruction()
    {
        return instruction;
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

    @Override
    public String toString()
    {
        return "Test{" +
                "id=" + id +
                ", instruction='" + instruction + '\'' +
                ", qcount=" + qcount +
                ", subject=" + subject +
                ", question=" + question +
                '}';
    }
}
