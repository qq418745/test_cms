package com.hjc.cms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

import static com.hjc.cms.IConst.DEFAULT_TIME_PATTERN;


/**
 * cms_hjc
 * Mr.liuchengming
 * 2019-08-23 13:55
 **/
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "park_jy_statement")
public class JyStatement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone = "GMT+8")
    private Timestamp dayTime;
    @ManyToOne
    @JoinColumn(name = "park_id")
    private Park park;
    private  Float  cashMny;
    private  Float  netMny;
    private  Float  vipGradeMny;
    private  Float  appWxZfbMny;
    private  Float  hotelCouMny ;
    private  Float  freeReleaseMny ;
    private  Integer  inCarNum;
    private  Integer  outCarNum;
    private  Float  sumMoney;
    public JyStatement(Timestamp dayTime, Park park, Float cashMny, Float netMny, Float vipGradeMny, Float appWxZfbMny, Float hotelCouMny, Float freeReleaseMny, Integer inCarNum, Integer outCarNum, Float sumMoney) {
        this.dayTime = dayTime;
        this.park = park;
        this.cashMny = cashMny;
        this.netMny = netMny;
        this.vipGradeMny = vipGradeMny;
        this.appWxZfbMny = appWxZfbMny;
        this.hotelCouMny = hotelCouMny;
        this.freeReleaseMny = freeReleaseMny;
        this.inCarNum = inCarNum;
        this.outCarNum = outCarNum;
        this.sumMoney = sumMoney;
    }
}
