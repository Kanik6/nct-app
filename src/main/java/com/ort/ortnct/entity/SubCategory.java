package com.ort.ortnct.entity;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "sub_categories")
@ApiModel(value = "sub category model")
public class SubCategory
{
    @Column(name = "sub_category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sub_category_name")
    private String subCategoryName;

    @ManyToOne
    @JoinTable(name = "category_sub_categories",
            inverseJoinColumns = @JoinColumn(name = "category_id"),
            joinColumns = @JoinColumn(name = "sub_category_id"))
    private Category category;

    @OneToOne(mappedBy = "subCategory")
    private Subject subject;

    public SubCategory()
    {
    }

    public SubCategory(String subCategoryName, Category category, Subject subject)
    {
        this.subCategoryName = subCategoryName;
        this.category = category;
        this.subject = subject;
    }

    public Long getId()
    {
        return id;
    }

    public String getSubCategoryName()
    {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName)
    {
        this.subCategoryName = subCategoryName;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    @Override
    public String toString()
    {
        return "SubCategory{" +
                "id=" + id +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", category=" + category +
                ", subject=" + subject +
                '}';
    }
}
