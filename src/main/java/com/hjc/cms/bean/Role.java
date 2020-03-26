package com.hjc.cms.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
@Getter
@Setter
@Accessors(chain = true)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Role")
    @TableGenerator(name = "Role")
    private Integer id;
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_mod", joinColumns = {@JoinColumn(name = "role_id")}
            , inverseJoinColumns = {@JoinColumn(name = "mod_id")})
    @Fetch(FetchMode.SELECT)
    private List<Mod> mods;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id != null ? id.equals(role.id) : role.id == null && (name != null ? name.equals(role.name) : role.name == null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}