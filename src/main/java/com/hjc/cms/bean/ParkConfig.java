package com.hjc.cms.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by xd on 2017/5/18.
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
public class ParkConfig implements Serializable {
    public enum ProxyType {HJC, CK, GM, RCB,GD,JBT}
    public enum InvoiceType {YL, NO, HT}
    @Id
    private String parkId;

    private String showTitle;
    private Integer duration;
    private String city;

    @Enumerated(EnumType.STRING)
    private ProxyType proxyType;

    @Enumerated(EnumType.STRING)
    private InvoiceType invoiceType;

    // RCB config
    private String userName, password, serialNo;
    //第三方 url和验证码
    private String baseSecurityCode, baseUrl;
    //posPayConfig
    private String posMid, posTid;
    //航天企业识别码
    private String jskpCode;
    //YL无感支付 收款账号 文档 http://122.112.238.243:8400/public/parking/national/#/支付/post_pay_bill
    private String ylIndustryCode, ylAppId;
    private Integer advSwitch; //是否开启广告  1 为开
    private Integer  followSwitch; //微信关注开关  1 为开
    private Integer frontVersion;
    private String gdmchId;//光大商户号
}
