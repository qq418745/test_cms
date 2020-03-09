package com.hjc.cms.service;

import com.hjc.cms.bean.JyStatement;
import com.hjc.cms.bean.entity.PageResult;

import java.sql.Timestamp;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-02-13 17:42
 **/
public interface ParkJyStatementService {

    PageResult findPage(JyStatement jyStatement, Timestamp startTime, Timestamp endTime, int page, int rows);
}
