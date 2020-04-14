package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

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
    @Getter
    private Long id;

    @Column(name = "answer")
    @Getter
    @Setter
    @NotBlank(message = "Answer is mandatory")
    private String answer;

    @Column(name = "is_correct")
    @Getter
    @Setter
    private boolean isCorrect;

    @Column(name = "image", columnDefinition = "text")
    @Getter
    @Setter
    private String image;

    @JsonIgnore
    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "question_answers",
            inverseJoinColumns = @JoinColumn(name = "question_id"),
            joinColumns = @JoinColumn(name = "answer_id"))
    private Question question;

}
