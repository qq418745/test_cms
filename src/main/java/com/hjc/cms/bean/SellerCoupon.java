package com.hjc.cms.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
@Entity
@Table(name = "t_seller_coupon")
public class SellerCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "seller_coupon")
    @TableGenerator(name = "seller_coupon")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private User user;

    private Integer count;
    private Integer occupied;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timeStamp;
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
}
