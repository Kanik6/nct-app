package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "subjects")
@ApiModel(value = "subject model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Getter
@Setter
public class Subject
{
    @Column(name = "subject_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(position = 0)
    private Long id;

    @Column(name = "subject_name")
    @NotBlank(message = "subject name is mandatory!")
    @ApiModelProperty(position = 1)
    private String name;

    @ManyToOne
    private Set<Language> lang;

    @OneToMany
    private Set<Grade> grade;




//    @Column(name = "creation_date")
//    @DateTimeFormat(style = "yyyy-MM-dd")
//    @ApiModelProperty(position = 3)
//    private LocalDate creationDate = LocalDate.now();

}
