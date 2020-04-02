package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;


@Entity
@Table(name = "test_result_ort")
public class TestResultOrt
{
    @Id
    @Column(name = "test_ort_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score")
    private Long score;


    @OneToOne
    @JoinColumn(name = "user_id")
    private Usr usr;


    @Transient
    private String usrId;

    public TestResultOrt()
    {
    }

    public TestResultOrt(Long score, String usrId)
    {
        this.score = score;
        this.usrId = usrId;
    }

    public Long getId()
    {
        return id;
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

    @JsonIgnore
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

    @Override
    public String toString()
    {
        return "TestResultOrt{" +
                "id=" + id +
                ", score=" + score +
                ", usr=" + usr +
                ", usrId='" + usrId + '\'' +
                '}';
    }
}
