package com.hjc.cms.controller;


import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hjc_cms
 * info: 管理平台 首页统计图
 * Mr.liuchengming
 * 2020-03-04 17:31
 **/
@RestController
@RequestMapping("statistics")
public class StatisticsController extends BaseController{

     @Autowired
     StatisticsService statisticsService;
    /**
     * 收款类型占比
     */
    @RequestMapping("chargeType")
    public Result chargeType( ){

        return statisticsService.chargeType(currentUserParkIds());
    }

    /**
     * 7天内 每天收费金额
     */
    @RequestMapping("orderMoneyWeek")
    public Result ordeMoneyrWeek( ){
        return statisticsService.ordeMoneyrWeek(currentUserParkIds());
    }
}
