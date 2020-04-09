package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "answers")
@ApiModel(value = "answer model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
//@JsonIdentityReference(alwaysAsId = true)
public class Answer
{
    @Column(name = "answer_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer")
    @NotBlank(message = "Answer is mandatory")
    private String answer;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Column(name = "image", columnDefinition = "text")
    private String image;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "question_answers",
            inverseJoinColumns = @JoinColumn(name = "question_id"),
            joinColumns = @JoinColumn(name = "answer_id"))
    private Question question;


    public Answer()
    {
    }

    public Answer(String answer, boolean isCorrect, String image)
    {
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.image = image;
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

    public boolean getCorrect()
    {
        return isCorrect;
    }

    public void setCorrect(boolean correct)
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

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", isCorrect=" + isCorrect +
                ", image='" + image + '\'' +
                ", question=" + question +
                '}';
    }
}
