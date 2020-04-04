package com.ort.ortnct.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "edu_material")
@ApiModel(value = "Educational material model")
public class EduMaterial
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "subject_name")
    private String subjectName;

    @Lob
    @Column(name = "conent")
    private String content;

    public EduMaterial()
    {
    }

    public EduMaterial(String subjectName, String content)
    {
        this.subjectName = subjectName;
        this.content = content;
    }

    public Long getId()
    {
        return id;
    }

    public String getSubjectName()
    {
        return subjectName;
    }

    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "EduMaterial{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
