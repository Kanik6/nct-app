package com.ort.ortnct.entity;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category
{
    @Column(name = "category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategory;

    public Category()
    {
    }

    public Category(String name, List<SubCategory> subCategory)
    {
        this.name = name;
        this.subCategory = subCategory;
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
