package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private Usr usr;

    @Transient
    private String usr_id;

    public TestResultOrt()
    {
    }

    public TestResultOrt(Long score, String usr_id)
    {
        this.score = score;
        this.usr_id = usr_id;
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

    public void setUsr(Usr usr)
    {
        this.usr = usr;
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
        return "TestResultOrt{" +
                "id=" + id +
                ", score=" + score +
                ", usr=" + usr +
                ", usr_id='" + usr_id + '\'' +
                '}';
    }
}
