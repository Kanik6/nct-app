package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
@ApiModel(value = "user model")
public class Usr
{
    @Column(name = "usr_id", nullable = false, unique = true)
    @Id
    @ApiModelProperty(position = 0)
    private String id;

    @Column(name = "age")
    @ApiModelProperty(position = 1)
    private Long age;

    @Column(name = "region")
    @ApiModelProperty(position = 2)
    private String region;

    @Column(name = "grade")
    @ApiModelProperty(position = 3)
    private Long grade;

    @JsonIgnore
    @OneToOne(mappedBy = "usr")
    @ApiModelProperty(position = 4)
    private TestResultNct result;

    @JsonIgnore
    @OneToOne(mappedBy = "usr")
    @ApiModelProperty(position = 5)
    private TestResultOrt resultOrt;

    @JsonIgnore
    @OneToMany(mappedBy = "usrr")
    @ApiModelProperty(position = 6)
    private List<UsrAnswer> usrAnswer;

    public Usr()
    {
    }

    public Usr(String id, Long age, String region, Long grade)
    {
        this.id = id;
        this.age = age;
        this.region = region;
        this.grade = grade;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public Long getAge()
    {
        return age;
    }

    public void setAge(Long age)
    {
        this.age = age;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public Long getGrade()
    {
        return grade;
    }

    public void setGrade(Long grade)
    {
        this.grade = grade;
    }

    public TestResultNct getResult()
    {
        return result;
    }

    public void setResult(TestResultNct result)
    {
        this.result = result;
    }

    public List<UsrAnswer> getUsrAnswer()
    {
        return usrAnswer;
    }

    public void setUsrAnswer(List<UsrAnswer> usrAnswer)
    {
        this.usrAnswer = usrAnswer;
    }

    @Override
    public String toString()
    {
        return "Usr{" +
                "id=" + id +
                ", age=" + age +
                ", region='" + region + '\'' +
                ", grade=" + grade +
                ", result=" + result +
                ", usrAnswer=" + usrAnswer +
                '}';
    }
}
