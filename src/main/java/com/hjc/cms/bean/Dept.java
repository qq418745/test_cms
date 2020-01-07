package com.hjc.cms.bean;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_dept")
public class Dept implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dept")
    @TableGenerator(name = "dept")
    private Integer id;
    private String name;
    private Integer parent;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_dept_role", joinColumns = {@JoinColumn(name = "dept_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SELECT)
    List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }
}