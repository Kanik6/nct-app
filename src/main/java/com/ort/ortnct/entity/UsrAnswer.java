package com.ort.ortnct.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr_answers")
@ApiModel(value = "user answer model")
public class UsrAnswer
{
    @Column(name = "usr_answer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usr_id")
    private Usr usr;

    @ManyToOne
    @JoinTable(name = "usrs_answers",
            inverseJoinColumns = @JoinColumn(name = "usr_id"),
            joinColumns = @JoinColumn(name = "usr_answer_id"))
    private Usr usrr;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(name = "answe_id")
    private Long answerId;

    public UsrAnswer()
    {
    }

    public UsrAnswer(Usr usr, Usr usrr, Test test, Answer answer)
    {
        this.usr = usr;
        this.usrr = usrr;
        this.test = test;
        this.answer = answer;
    }

    public Long getId()
    {
        return id;
    }

    public Usr getUsr()
    {
        return usr;
    }

    public void setUsr(Usr usr)
    {
        this.usr = usr;
    }

    public Test getTest()
    {
        return test;
    }

    public void setTest(Test test)
    {
        this.test = test;
    }

    public Answer getAnswer()
    {
        return answer;
    }

    public void setAnswer(Answer answer)
    {
        this.answer = answer;
    }

    public Long getAnswerId()
    {
        return answerId;
    }

    public void setAnswerId(Long answerId)
    {
        this.answerId = answerId;
    }

    @Override
    public String toString()
    {
        return "UsrAnswer{" +
                "id=" + id +
                ", usr=" + usr +
                ", usrr=" + usrr +
                ", test=" + test +
                ", answer=" + answer +
                ", answerId=" + answerId +
                '}';
    }
}
