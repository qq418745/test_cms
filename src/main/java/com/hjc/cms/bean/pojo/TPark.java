package com.hjc.cms.bean.pojo;

import java.util.Date;
/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-03 10:35
 **/

public class TPark {
    private String parkId;

    private String parkName;

    private Short proxyState;

    private Integer freeCount;

    private Integer proxyVersion;

    private Date lastUpdate;

    private Integer wxConfig;

    private Integer aliConfig;

    private Integer ylConfig;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId == null ? null : parkId.trim();
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName == null ? null : parkName.trim();
    }

    public Short getProxyState() {
        return proxyState;
    }

    public void setProxyState(Short proxyState) {
        this.proxyState = proxyState;
    }

    public Integer getFreeCount() {
        return freeCount;
    }

    public void setFreeCount(Integer freeCount) {
        this.freeCount = freeCount;
    }

    public Integer getProxyVersion() {
        return proxyVersion;
    }

    public void setProxyVersion(Integer proxyVersion) {
        this.proxyVersion = proxyVersion;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getWxConfig() {
        return wxConfig;
    }

    public void setWxConfig(Integer wxConfig) {
        this.wxConfig = wxConfig;
    }

    public Integer getAliConfig() {
        return aliConfig;
    }

    public void setAliConfig(Integer aliConfig) {
        this.aliConfig = aliConfig;
    }

    public Integer getYlConfig() {
        return ylConfig;
    }

    public void setYlConfig(Integer ylConfig) {
        this.ylConfig = ylConfig;
    }
}