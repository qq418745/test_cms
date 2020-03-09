package com.hjc.cms.bean;

import javax.persistence.*;

@Entity
@Table(name = "t_dynamic_conf")
public class DynamicConf {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "DynamicConf")
    @TableGenerator(name = "DynamicConf")
    private int id;
    @Column(name = "group_no")
    private int groupNo;

    private String confName;
    private String confValue;
    @Column(name = "conf_desc")
    private String confDesc;

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public String getConfValue() {
        return confValue;
    }

    public void setConfValue(String confValue) {
        this.confValue = confValue;
    }

    public String getConfDesc() {
        return confDesc;
    }

    public void setConfDesc(String confDesc) {
        this.confDesc = confDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }
}
