package com.ort.ortnct.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "views")
@ApiModel(value = "view model")
public class View
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "view_id")
    private long id;

    @Column(name = "view_name")
    private String viewName;

    @Column(name = "http_method")
    private String method;

    @Column(name = "view_title")
    private String viewTitle;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "view_role",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public View()
    {
    }

    public View(String viewName, String method, String viewTitle, Set<Role> roles)
    {
        this.viewName = viewName;
        this.method = method;
        this.viewTitle = viewTitle;
        this.roles = roles;
    }

    public long getId()
    {
        return id;
    }

    public String getViewName()
    {
        return viewName;
    }

    public void setViewName(String viewName)
    {
        this.viewName = viewName;
    }

    public String getMethod()
    {
        return method;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }

    public String getViewTitle()
    {
        return viewTitle;
    }

    public void setViewTitle(String viewTitle)
    {
        this.viewTitle = viewTitle;
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
        return "View{" +
                "id=" + id +
                ", viewName='" + viewName + '\'' +
                ", method='" + method + '\'' +
                ", viewTitle='" + viewTitle + '\'' +
                ", roles=" + roles +
                '}';
    }
}
