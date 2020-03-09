package com.hjc.cms.service.impl;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hjc.cms.bean.entity.MapResult;
import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.bean.pojo.TOrderExample;
import com.hjc.cms.dao.mapper.TOrderMapper;
import com.hjc.cms.service.StatisticsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-03-04 17:44
 **/
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    TOrderMapper orderMapper;
    @Override
    public Result chargeType(String[] parkIds) {
//        TOrderExample example=new TOrderExample();
//        example.setParkIds(parkIds);
        List<MapResult> chargeTypeByExample = orderMapper.findChargeTypeByExample(parkIds);
        return new Result(true, "0").setInfo(chargeTypeByExample);
    }

    @Override
    public Result ordeMoneyrWeek(String[] parkids) {

        List<MapResult> chargeTypeByExample =    orderMapper.findOrdeMoneyrWeekParkIds(parkids);
        return new Result(true, "0").setInfo(chargeTypeByExample);
    }
}
