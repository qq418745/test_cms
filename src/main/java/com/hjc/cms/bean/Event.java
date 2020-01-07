package com.hjc.cms.bean;

//import xd.fw.service.IConst;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by xd on 2017/5/7.
 */
@Entity
@Table(name = "t_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "event")
    @TableGenerator(name = "event")
    private Integer id;
    private Integer eventType;
    private Integer dbKey;
    private String dbStr;
    private Integer status;
    private Timestamp upDate;

    public Event() {
    }

    public Event(Integer eventType, Integer dbKey) {
        this.eventType = eventType;
        this.dbKey = dbKey;
//        this.status = IConst.STATUS_INI;
        this.upDate = new Timestamp(System.currentTimeMillis());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getDbKey() {
        return dbKey;
    }

    public void setDbKey(Integer dbKey) {
        this.dbKey = dbKey;
    }

    public String getDbStr() {
        return dbStr;
    }

    public void setDbStr(String dbStr) {
        this.dbStr = dbStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getUpDate() {
        return upDate;
    }

    public void setUpDate(Timestamp upDate) {
        this.upDate = upDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (eventType != null ? !eventType.equals(event.eventType) : event.eventType != null) return false;
        if (dbKey != null ? !dbKey.equals(event.dbKey) : event.dbKey != null) return false;
        if (dbStr != null ? !dbStr.equals(event.dbStr) : event.dbStr != null) return false;
        if (status != null ? !status.equals(event.status) : event.status != null) return false;
        if (upDate != null ? !upDate.equals(event.upDate) : event.upDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (dbKey != null ? dbKey.hashCode() : 0);
        result = 31 * result + (dbStr != null ? dbStr.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (upDate != null ? upDate.hashCode() : 0);
        return result;
    }
}
