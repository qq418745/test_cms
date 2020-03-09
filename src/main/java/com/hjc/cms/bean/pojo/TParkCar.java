package com.hjc.cms.bean.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

import static com.hjc.cms.IConst.DEFAULT_TIME_PATTERN;

/**
 * Created by Mr.wayne on 2020/1/9 9:05.
 */
public class TParkCar {
    private Integer id;
    private String carNumber;
    private String parkId;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone = "GMT+8")
    private Date enterTime;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone = "GMT+8")
    private Date outTime;
    private String orderId;
    private String operator;
    private Float totalFee;
    private String deviceId;
    private TPark tPark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Float totalFee) {
        this.totalFee = totalFee;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public TPark getTPark() {
        return tPark;
    }

    public void setTPark(TPark tPark) {
        this.tPark = tPark;
    }
}
