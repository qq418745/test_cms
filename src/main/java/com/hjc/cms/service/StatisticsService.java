package com.hjc.cms.service;

import com.hjc.cms.bean.entity.Result;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-03-04 17:43
 **/
public interface StatisticsService {

    Result chargeType(String[] parkIds);

    Result ordeMoneyrWeek(String[] currentUserParkIds);
}
