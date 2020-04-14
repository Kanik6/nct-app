package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
    @Getter
    private String id;

    @Column(name = "age")
    @ApiModelProperty(position = 1)
    @Getter
    @Setter
    private Long age;

    @Column(name = "region")
    @ApiModelProperty(position = 2)
    @Getter
    @Setter
    private String region;

    @Column(name = "grade")
    @ApiModelProperty(position = 3)
    @Getter
    @Setter
    private Long grade;

    @JsonIgnore
    @OneToOne(mappedBy = "usr")
    @ApiModelProperty(position = 4)
    @Getter
    @Setter
    private TestResultNct result;

    @JsonIgnore
    @OneToMany(mappedBy = "usrr")
    @ApiModelProperty(position = 6)
    @Getter
    @Setter
    private List<UsrAnswer> usrAnswer;

}
