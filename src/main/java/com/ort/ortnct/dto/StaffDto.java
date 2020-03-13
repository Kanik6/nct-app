package com.ort.ortnct.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ort.ortnct.entity.Role;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

public class StaffDto
{
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private boolean isMale;

    private String phoneNumber;

    private String email;

    private String login;

    private String password;

    private String position;

    private String relatedCategory;

    private Set<Role> roles;
}
