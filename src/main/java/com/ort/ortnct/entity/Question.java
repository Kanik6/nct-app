package com.ort.ortnct.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
@ApiModel(value = "question model")
public class Question
{
    @Column(name = "question_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question")
    private String question;

    @ManyToOne
    @JoinTable(name = "test_questions",
            inverseJoinColumns = @JoinColumn(name = "test_id"),
            joinColumns = @JoinColumn(name = "question_id"))
    private Test test;


    @OneToMany(mappedBy = "question")
    private List<Answer> answer;

    public Question()
    {
    }

    public Question(String question, Test test, List<Answer> answer)
    {
        this.question = question;
        this.test = test;
        this.answer = answer;
    }

    public Long getId()
    {
        return id;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Test getTest()
    {
        return test;
    }

    public void setTest(Test test)
    {
        this.test = test;
    }

    public List<Answer> getAnswer()
    {
        return answer;
    }

    public void setAnswer(List<Answer> answer)
    {
        this.answer = answer;
    }

    @Override
    public String toString()
    {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", test=" + test +
                ", answer=" + answer +
                '}';
    }
}
