package com.ort.ortnct.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ort.ortnct.entity.Role;

import java.time.LocalDate;
import java.util.Set;

public class StaffDto
{
    @JsonIgnore
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

    @JsonIgnore
    private String relatedCategory;
    @JsonIgnore
    private Set<Role> roles;

    public StaffDto()
    {
    }

    public StaffDto(Long id, String firstName, String lastName, LocalDate birthDate, boolean isMale, String phoneNumber, String email, String login, String password, String position, String relatedCategory, Set<Role> roles)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.login = login;
        this.password = password;
        this.position = position;
        this.relatedCategory = relatedCategory;
        this.roles = roles;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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

    public boolean isMale()
    {
        return isMale;
    }

    public void setMale(boolean male)
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
}
