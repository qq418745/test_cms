package com.hjc.cms.bean.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

import static com.hjc.cms.IConst.DEFAULT_TIME_PATTERN;


/**
 * Created by xd on 2017/5/18.
 */
@Accessors(chain = true)
@NoArgsConstructor
@Getter
@Setter
@ToString()
public class TbOrder {
   // public enum DiscountType {NONE, JF, PAPER, GOLD_FEE} // 1积分 2券 3 金卷免费

    private String outTradeNo;
    private String tradeNo;
    private String carNumber;
    private Integer totalFee;
    private Integer payStatus;
    private Integer notifyStatus;
    private Integer payFlag;
    private String watchId;
    private Byte carType;
    private String sId;
    private String openid;
    private String openIdForOwner;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN)
    private String enterTime;
    @JsonFormat(pattern = DEFAULT_TIME_PATTERN)
    private Timestamp timeStamp;

    private String dueTime;
    private String billId;


    String discountType;
    String discountDetail;
    Integer discountFee;
    private String parkId;




}
