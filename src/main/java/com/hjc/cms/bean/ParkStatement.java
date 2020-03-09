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
 * @program: cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2019-08-23 13:55
 **/
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "park_statement")
public class ParkStatement implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN, timezone = "GMT+8")
    private Timestamp dayTime;
    @ManyToOne
    @JoinColumn(name = "park_id")
    private Park park;
    private  Integer  cashMny;
    private  Integer  netMny;
    private  Integer  vipGradeMny;
    private  Integer  appWxZfbMny;
    private  Integer  hotelCouMny ;
    private  Integer  freeReleaseMny ;
    private  Integer  inCarNum;
    private  Integer  outCarNum;
    private  Integer  sumMoney;

}
