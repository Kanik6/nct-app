package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "test_result")
@ApiModel(value = "test result model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class TestResult
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_result_id")
    private Long id;

    @Column(name = "correct")
    private Long correct;

    @Column(name = "incorrect")
    private Long incorrect;

    @Column(name = "score")
    private Long score;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private Usr usr;

    @Transient
    private String usr_id;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "test_results",
            joinColumns = @JoinColumn(name = "test_result_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Subject subject;

    @Transient
    private Long subjectId;

    public TestResult()
    {
    }

    public TestResult(Long correct, Long incorrect, Long score, String usr_id, Long subjectId)
    {
        this.correct = correct;
        this.incorrect = incorrect;
        this.score = score;
        this.usr_id = usr_id;
        this.subjectId = subjectId;
    }

    public Long getId()
    {
        return id;
    }

    public Long getCorrect()
    {
        return correct;
    }

    public void setCorrect(Long correct)
    {
        this.correct = correct;
    }

    public Long getIncorrect()
    {
        return incorrect;
    }

    public void setIncorrect(Long incorrect)
    {
        this.incorrect = incorrect;
    }

    public Long getScore()
    {
        return score;
    }

    public void setScore(Long score)
    {
        this.score = score;
    }

    public Usr getUsr()
    {
        return usr;
    }

    public void setUsr(Usr usr)
    {
        this.usr = usr;
    }

    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId = true)
    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public Long getSubjectId()
    {
        return subjectId;
    }

    public void setSubjectId(Long subjectId)
    {
        this.subjectId = subjectId;
    }

    public String getUsr_id()
    {
        return usr_id;
    }

    public void setUsr_id(String usr_id)
    {
        this.usr_id = usr_id;
    }

    @Override
    public String toString()
    {
        return "TestResult{" +
                "id=" + id +
                ", correct=" + correct +
                ", incorrect=" + incorrect +
                ", score=" + score +
                ", usr=" + usr +
                ", usr_id='" + usr_id + '\'' +
                ", subject=" + subject +
                ", subjectId=" + subjectId +
                '}';
    }
}
