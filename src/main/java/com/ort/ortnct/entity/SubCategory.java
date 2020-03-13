package com.ort.ortnct.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ort.ortnct.enums.SubCategories;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sub_categories")
@ApiModel(value = "sub category model")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId = true)
public class SubCategory
{
    @Column(name = "sub_category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sub_category_name")
    @Enumerated(EnumType.STRING)
    private SubCategories subCategoryName;

    @ManyToOne
    @JoinTable(name = "category_sub_categories",
            inverseJoinColumns = @JoinColumn(name = "category_id"),
            joinColumns = @JoinColumn(name = "sub_category_id"))
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Subject> subjects;

    public SubCategory()
    {
    }

    public SubCategory(SubCategories subCategoryName, Category category, List<Subject> subjects)
    {
        this.subCategoryName = subCategoryName;
        this.category = category;
        this.subjects = subjects;
    }

    public Long getId()
    {
        return id;
    }

    public SubCategories getSubCategoryName()
    {
        return subCategoryName;
    }

    public void setSubCategoryName(SubCategories subCategoryName)
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

    public List<Subject> getSubject()
    {
        return subjects;
    }

    public void setSubject(List<Subject> subjects)
    {
        this.subjects = subjects;
    }

    @Override
    public String toString()
    {
        return "SubCategory{" +
                "id=" + id +
                ", subCategoryName='" + subCategoryName + '\'' +
                ", category=" + category +
                ", subject=" + subjects +
                '}';
    }
}
