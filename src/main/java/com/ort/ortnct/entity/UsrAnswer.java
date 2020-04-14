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
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(name = "answe_id")
    private Long answerId;
}
