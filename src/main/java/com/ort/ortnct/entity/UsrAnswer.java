package com.ort.ortnct.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr_answers")
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

    @Column(name = "us_id")
    private String usrId;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "tes_id")
    private Long testId;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(name = "answe_id")
    private Long answerId;

    public UsrAnswer()
    {
    }

    public UsrAnswer(String usrId, Long testId, Long answerId, Usr usrr)
    {
        this.usrId = usrId;
        this.testId = testId;
        this.answerId = answerId;
        this.usrr = usrr;
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

    public String getUsrId()
    {
        return usrId;
    }

    public void setUsrId(String usrId)
    {
        this.usrId = usrId;
    }

    public Test getTest()
    {
        return test;
    }

    public void setTest(Test test)
    {
        this.test = test;
    }

    public Long getTestId()
    {
        return testId;
    }

    public void setTestId(Long testId)
    {
        this.testId = testId;
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
                ", usrId=" + usrId +
                ", test=" + test +
                ", testId=" + testId +
                ", answer=" + answer +
                ", answerId=" + answerId +
                '}';
    }
}
