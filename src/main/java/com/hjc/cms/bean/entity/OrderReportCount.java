package com.hjc.cms.bean.entity;




import java.io.Serializable;





/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-14 15:34
 **/
public class OrderReportCount implements Serializable {

    private int count ; //总条数
    private int sumDiscountFee ; //总优惠金额
    private int sumTotalFee ; //总金额
    //@JsonFormat(pattern = DEFAULT_DATE_PATTERN, timezone = "GMT+8")
    private String time; //日期 天

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

