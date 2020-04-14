package com.ort.ortnct.entity;

import com.ort.ortnct.enums.ListOfGrade;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "grades")
public class Grade
{
    @Column(name = "grade_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "grade")
    private ListOfGrade listOfGrade;

    @OneToMany
    private Set<Variant> variants;
}
