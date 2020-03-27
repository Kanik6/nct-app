package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "test_result")
@ApiModel(value = "test result model")
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private Usr usr;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "test_results",
            inverseJoinColumns = @JoinColumn(name = "subject_id"),
            joinColumns = @JoinColumn(name = "subject_result_id"))
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public TestResult()
    {
    }

    public TestResult(Long correct, Long incorrect, Long score, Usr usr, Subject subject)
    {
        this.correct = correct;
        this.incorrect = incorrect;
        this.score = score;
        this.usr = usr;
        this.subject = subject;
    }

    public Long getId()
    {
        return id;
    }

    public Long getCorrect()
    {
        return correct;
    }

    public void setCorrect(Long corrent)
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

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
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
                ", subject=" + subject +
                '}';
    }
}
