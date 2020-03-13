package com.hjc.cms.service;

import com.hjc.cms.bean.Park;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.entity.Result;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-20 09:35
 **/
public interface ParkService {


    PageResult findPage(Park park, int page, int rows, String[] parkIds);

    void save(Park park);
}
