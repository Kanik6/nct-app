package com.ort.ortnct.entity;

import javax.persistence.*;

@Entity
@Table(name = "test_result")
public class TestResult
{
    @Column(name = "test_result_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usr_id")
    private Usr usr;

    @Column(name = "us_id")
    private String usrId;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @Column(name = "tes_id")
    private Long testId;

    @Column(name = "correct")
    private Long correct;

    @Column(name = "in_correct")
    private Long inCorrect;

    public TestResult()
    {
    }

    public TestResult(String usrId, Long testId, Long correct, Long inCorrect)
    {
        this.usrId = usrId;
        this.testId = testId;
        this.correct = correct;
        this.inCorrect = inCorrect;
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

    public Long getCorrect()
    {
        return correct;
    }

    public void setCorrect(Long correct)
    {
        this.correct = correct;
    }

    public Long getInCorrect()
    {
        return inCorrect;
    }

    public void setInCorrect(Long inCorrect)
    {
        this.inCorrect = inCorrect;
    }

    @Override
    public String toString()
    {
        return "TestResult{" +
                "id=" + id +
                ", usrId=" + usrId +
                ", testId=" + testId +
                ", correct=" + correct +
                ", inCorrect=" + inCorrect +
                '}';
    }
}
