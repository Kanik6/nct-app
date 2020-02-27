package com.ort.ortnct.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
public class Usr
{
    @Column(name = "usr_id", nullable = false, unique = true)
    @Id
    private String id;

    @Column(name = "age")
    private Long age;

    @Column(name = "region")
    private String region;

    @Column(name = "grade")
    private Long grade;

    @OneToOne(mappedBy = "usr")
    private TestResult result;

    @OneToMany(mappedBy = "usrr")
    private List<UsrAnswer> usrAnswer;

    public Usr()
    {
    }

    public Usr(String id, Long age, String region, Long grade, TestResult result, List<UsrAnswer> usrAnswer)
    {
        this.id = id;
        this.age = age;
        this.region = region;
        this.grade = grade;
        this.result = result;
        this.usrAnswer = usrAnswer;
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

    public TestResult getResult()
    {
        return result;
    }

    public void setResult(TestResult result)
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
