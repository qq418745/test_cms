package com.hjc.cms.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_mod")
public class Mod {
    @Id
    private Integer id;
    private String name;
    private String url;

    private String routerId;
    private String addition;
    private Integer parentId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRouterId() {
        return routerId;
    }

    public void setRouterId(String routerId) {
        this.routerId = routerId;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mod mod = (Mod) o;

        if (id != null ? !id.equals(mod.id) : mod.id != null) return false;
        if (name != null ? !name.equals(mod.name) : mod.name != null) return false;
        if (url != null ? !url.equals(mod.url) : mod.url != null) return false;
        if (routerId != null ? !routerId.equals(mod.routerId) : mod.routerId != null) return false;
        if (addition != null ? !addition.equals(mod.addition) : mod.addition != null) return false;
        return parentId != null ? parentId.equals(mod.parentId) : mod.parentId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (routerId != null ? routerId.hashCode() : 0);
        result = 31 * result + (addition != null ? addition.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }
}