package com.hjc.cms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_coupon")
public class Coupon {
    public static final Short CATEGORY_TIME = 1, CATEGORY_DURATION = 2, CATEGORY_MONEY = 3;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "coupon")
    @TableGenerator(name = "coupon")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "park_id")
    private Park park;

    private String name;
    private Short category;
    private Integer duration;
    private Float amount;
    private Integer creator;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
}
