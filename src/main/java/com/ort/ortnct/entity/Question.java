package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

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
    @Getter
    private Long id;

    @Column(name = "question")
    @NotBlank(message = "Question is mandatory!")
    @Getter
    @Setter
    private String question;

    @Column(name = "explanation")
    @Getter
    @Setter
    private String explanation;

    @Column(name = "image", columnDefinition = "text")
    @Getter
    @Setter
    private String image;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @Getter
    @Setter
    @JoinTable(name = "subject_questions",
            inverseJoinColumns = @JoinColumn(name = "subject_id"),
            joinColumns = @JoinColumn(name = "question_id"))
    private Subject subject;

//    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Answer> answer;
}
