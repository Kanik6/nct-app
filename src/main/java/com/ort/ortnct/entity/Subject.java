package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ort.ortnct.enums.TestType;
import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "subjects")
@ApiModel(value = "subject model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Subject
{
    @Column(name = "subject_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name", unique = true)
    @NotBlank(message = "subject name is mandatory!")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "subject_sub_category",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    private SubCategory subCategory;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private Test test;

    @Column(name = "test_type")
    @Enumerated(EnumType.STRING)
    private TestType testType;

    public Subject()
    {
    }

    public Subject(String name, SubCategory subCategory)
    {
        this.name = name;
        this.subCategory = subCategory;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public SubCategory getSubCategory()
    {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory)
    {
        this.subCategory = subCategory;
    }

    public Test getTest()
    {
        return test;
    }

    public void setTest(Test test)
    {
        this.test = test;
    }

    public TestType getTestType()
    {
        return testType;
    }

    public void setTestType(TestType testType)
    {
        this.testType = testType;
    }

    @Override
    public String toString()
    {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategory=" + subCategory +
                ", test=" + test +
                ", testType=" + testType +
                '}';
    }
}
