package com.hjc.cms.bean.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;


import static com.hjc.cms.IConst.DEFAULT_DATE_PATTERN;


/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-14 15:34
 **/
public class OrderReportCount implements Serializable {

    private int count ; //总条数
    private int sumDiscountFee ;
    private int sumTotalFee ;
    @JsonFormat(pattern = DEFAULT_DATE_PATTERN, timezone = "GMT+8")
    private String day; //日期天

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSumDiscountFee() {
        return sumDiscountFee;
    }

    public void setSumDiscountFee(int sumDiscountFee) {
        this.sumDiscountFee = sumDiscountFee;
    }

    public int getSumTotalFee() {
        return sumTotalFee;
    }

    public void setSumTotalFee(int sumTotalFee) {
        this.sumTotalFee = sumTotalFee;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

