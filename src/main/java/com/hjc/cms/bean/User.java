package com.hjc.cms.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user")
    @TableGenerator(name = "user")
    private Integer id;

    private String name;
    private String password;

    private Date birthday;
    private Byte sex;
    private Date entryTime;
    private String mobile;
    private String phone;
    private String idCard;
    private String mail;
    private String remark;

    private Integer manager;
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "dept")
    private Dept dept;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "user_id")}
            , inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Role> roles;

    private String openId;
}
