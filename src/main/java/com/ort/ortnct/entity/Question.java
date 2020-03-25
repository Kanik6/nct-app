package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "questions")
@ApiModel(value = "question model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Question
{
    @Column(name = "question_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question")
    @NotBlank(message = "Question is mandatory!")
    private String question;

    @Column(name = "explanation")
    private String explanation;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "test_questions",
            inverseJoinColumns = @JoinColumn(name = "test_id"),
            joinColumns = @JoinColumn(name = "question_id"))
    private Test test;

//    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answer;

    @OneToOne
    @JoinColumn(name = "corrent_answer_for_question")
    private Answer correctAnswer;

    public Question()
    {
    }

    public Question(String question , String explanation)
    {
        this.question = question;
        this.explanation = explanation;
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

    public String getExplanation()
    {
        return explanation;
    }

    public void setExplanation(String explanation)
    {
        this.explanation = explanation;
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

    public Answer getCorrentAnswer()
    {
        return correctAnswer;
    }

    public void setCorrentAnswer(Answer correntAnswer)
    {
        this.correctAnswer = correntAnswer;
    }

    @Override
    public String toString()
    {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", explanation='" + explanation + '\'' +
                ", test=" + test +
                ", answer=" + answer +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
