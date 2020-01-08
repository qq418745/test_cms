package com.hjc.cms;
/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-03 10:35
 **/

public interface IConst {
    String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    String DEFAULT_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    String DEFAULT_TIME_PATTERN_TINY = "yyyyMMddHHmmss";
    int INVALIDATE_INT = -1000;

    String SUCCESS_FLAG = "SUCCESS";

    //event status
    int ES_INI = 0, ES_PROCESSING = 1, ES_DONE = 2, ES_FAIL = 3;

    Integer PAY_WX = 0, PAY_ALI = 1, PAY_YL = 2, PAY_YL_WX = 3, PAY_YL_ALI = 4, PAY_YL_CLOUD = 5, PAY_CMB = 6
            , PAY_RCB_CLOUD = 7, PAY_RCB_WX = 8, PAY_RCB_ALI = 9, PAY_ABC = 13;

    Integer STATUS_INI = 0, STATUS_DONE = 1, STATUS_FAIL = 2;

    Integer ORDER_STATUS_REFUND_DONE = 7, ORDER_STATUS_REFUND_FAIL = 8;

    Integer ORDER_STATUS_CLOSE_DONE = 9, ORDER_STATUS_CLOSE_FAIL = 10;
}