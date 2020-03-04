package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "answers")
@ApiModel(value = "answer model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Answer
{
    @Column(name = "answer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "question_answers",
            inverseJoinColumns = @JoinColumn(name = "question_id"),
            joinColumns = @JoinColumn(name = "answer_id"))
    private Question question;

    public Answer()
    {
    }

    public Answer(String answer, Boolean isCorrect)
    {
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public Long getId()
    {
        return id;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public Boolean getCorrect()
    {
        return isCorrect;
    }

    public void setCorrect(Boolean correct)
    {
        isCorrect = correct;
    }

    public Question getQuestion()
    {
        return question;
    }

    public void setQuestion(Question question)
    {
        this.question = question;
    }

    @Override
    public String toString()
    {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                ", question=" + question +
                '}';
    }
}
