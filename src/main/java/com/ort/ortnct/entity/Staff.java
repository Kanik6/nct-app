package com.ort.ortnct.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "staff")
@ApiModel(value = "staff model")
public class Staff
{

    @Column(name = "staff_id")
    @Id
    @SequenceGenerator(name = "mySeqGenStaff", sequenceName = "mySeqStaff", initialValue = 3, allocationSize = 1)
    @GeneratedValue(generator = "mySeqGenStaff")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Column(name = "is_male")
    private Boolean isMale;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "position")
    @ApiModelProperty(notes = "position of the staff , ADMIN or EDITOR")
    private String position;

    @JsonIgnore
    @Column(name = "related_category")
    @ApiModelProperty(notes = "related category ORT or NCT")
    private String relatedCategory;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "staff_roles",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Staff()
    {
    }

    public Staff(String firstName, String lastName, LocalDate birthDate, Boolean isMale, String phoneNumber, String email, String login, String password, String position)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.position = position;
    }

    public Long getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public Boolean getMale()
    {
        return isMale;
    }

    public void setMale(Boolean male)
    {
        isMale = male;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public String getRelatedCategory()
    {
        return relatedCategory;
    }

    public void setRelatedCategory(String relatedCategory)
    {
        this.relatedCategory = relatedCategory;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", isMale=" + isMale +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", position='" + position + '\'' +
                ", relatedCategory='" + relatedCategory + '\'' +
                ", roles=" + roles +
                '}';
    }
}
