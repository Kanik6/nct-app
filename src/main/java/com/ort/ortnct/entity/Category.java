package com.ort.ortnct.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "categories")
@ApiModel(value = "category model")
public class Category
{
    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    @NotBlank(message = "Category name is mandatory")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategory;

    public Category()
    {
    }

    public Category(String name)
    {
        this.name = name;
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

    public List<SubCategory> getSubCategory()
    {
        return subCategory;
    }

    public void setSubCategory(List<SubCategory> subCategory)
    {
        this.subCategory = subCategory;
    }

    @Override
    public String toString()
    {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }
}
