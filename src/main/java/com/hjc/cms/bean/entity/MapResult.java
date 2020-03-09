package com.hjc.cms.bean.entity;

import java.io.Serializable;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-03-05 10:50
 **/
public class MapResult implements Serializable {

    private  Object key;
    private  Object  value;

    public MapResult() {
    }

    public MapResult(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
