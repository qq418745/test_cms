package com.hjc.cms.bean.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;

import static com.hjc.cms.IConst.DEFAULT_TIME_PATTERN;
/**
 * @program: hjc_cms
 * Mr.liuchengming
 * 2020-01-03 12:35
 **/
public class TOrder {
    private String outTradeNo;

    private String tradeNo;

    private TPark tPark;


    private String carNumber;

    private Integer totalFee;

    private Short payStatus;

    private Short notifyStatus;

    private Short payFlag;

    private String watchId;

    private Byte carType;

    private String sId;

    private String openid;

    private String openIdForOwner;

    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone = "GMT+8")
    private String enterTime;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone = "GMT+8")
    private Date timeStamp;

    private Integer discountType;

    private Integer discountFee;

    private String discountDetail;

    private String cardId;

    private Integer applyStatus;

    private String dueTime;

    private String billId;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo == null ? null : outTradeNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }


    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public Short getNotifyStatus() {
        return notifyStatus;
    }

    public void setNotifyStatus(Short notifyStatus) {
        this.notifyStatus = notifyStatus;
    }

    public Short getPayFlag() {
        return payFlag;
    }

    public void setPayFlag(Short payFlag) {
        this.payFlag = payFlag;
    }

    public String getWatchId() {
        return watchId;
    }

    public void setWatchId(String watchId) {
        this.watchId = watchId == null ? null : watchId.trim();
    }

    public Byte getCarType() {
        return carType;
    }

    public void setCarType(Byte carType) {
        this.carType = carType;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getOpenIdForOwner() {
        return openIdForOwner;
    }

    public void setOpenIdForOwner(String openIdForOwner) {
        this.openIdForOwner = openIdForOwner == null ? null : openIdForOwner.trim();
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime == null ? null : enterTime.trim();
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Integer getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Integer discountFee) {
        this.discountFee = discountFee;
    }

    public String getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail == null ? null : discountDetail.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime == null ? null : dueTime.trim();
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId == null ? null : billId.trim();
    }

    public TPark getTPark() {
        return tPark;
    }

    public void setTPark(TPark tPark) {
        this.tPark = tPark;
    }

    public TPark gettPark() {
        return tPark;
    }

    public void settPark(TPark tPark) {
        this.tPark = tPark;
    }


}