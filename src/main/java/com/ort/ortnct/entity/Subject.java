package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ort.ortnct.enums.TestType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "subjects")
@ApiModel(value = "subject model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
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

    @Column(name = "creation_date")
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "subject_sub_category",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    @ApiModelProperty(position = 2)
    @JsonIgnore
    private SubCategory subCategory;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    @ApiModelProperty(position = 3)
//    @JsonIgnore
    private Test test;

    @Column(name = "test_type")
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(position = 4)
    @JsonIgnore
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

    public LocalDate getCreationDate()
    {
        return creationDate;
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
                ", creationDate=" + creationDate +
                ", subCategory=" + subCategory +
                ", test=" + test +
                ", testType=" + testType +
                '}';
    }
}
