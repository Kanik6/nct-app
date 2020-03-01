package com.ort.ortnct.entity;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@ApiModel(value = "subject model")
public class Subject
{
    @Column(name = "subject_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    @OneToOne(mappedBy = "subject")
    private Test test;

    public Subject()
    {
    }

    public Subject(String name, SubCategory subCategory, Test test)
    {
        this.name = name;
        this.subCategory = subCategory;
        this.test = test;
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

    @Override
    public String toString()
    {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategory=" + subCategory +
                ", test=" + test +
                '}';
    }
}
