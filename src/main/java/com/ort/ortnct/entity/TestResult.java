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
    private Long corrent;

    @Column(name = "incorrect")
    private Long incorrent;

    @Column(name = "score")
    private Long score;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Usr usr;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "test_results",
            inverseJoinColumns = @JoinColumn(name = "test_id"),
            joinColumns = @JoinColumn(name = "test_result_id"))
    @JoinColumn(name = "test_id")
    private Subject subject;

    public TestResult()
    {
    }

    public TestResult(Long corrent, Long incorrent, Long score, Usr usr, Subject subject)
    {
        this.corrent = corrent;
        this.incorrent = incorrent;
        this.score = score;
        this.usr = usr;
        this.subject = subject;
    }

    public Long getId()
    {
        return id;
    }

    public Long getCorrent()
    {
        return corrent;
    }

    public void setCorrent(Long corrent)
    {
        this.corrent = corrent;
    }

    public Long getIncorrent()
    {
        return incorrent;
    }

    public void setIncorrent(Long incorrent)
    {
        this.incorrent = incorrent;
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

    public Subject getTest()
    {
        return subject;
    }

    public void setTest(Subject subject)
    {
        this.subject = subject;
    }

    @Override
    public String toString()
    {
        return "TestResult{" +
                "id=" + id +
                ", corrent=" + corrent +
                ", incorrent=" + incorrent +
                ", score=" + score +
                ", usr=" + usr +
                ", subject=" + subject +
                '}';
    }
}
