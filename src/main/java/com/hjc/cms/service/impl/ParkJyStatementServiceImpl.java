package com.hjc.cms.service.impl;

import com.hjc.cms.bean.JyStatement;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.ParkJyStatementRepository;
import com.hjc.cms.service.ParkJyStatementService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-02-13 17:43
 **/
@Service
public class ParkJyStatementServiceImpl implements ParkJyStatementService {

    @Autowired
    ParkJyStatementRepository parkStatementRepository;


    @Override
    public PageResult findPage(JyStatement jyStatement, Timestamp startTime, Timestamp endTime, int page, int rows) {
           Page<JyStatement> list = parkStatementRepository.findAll(parkName(jyStatement), startTime,endTime,PageRequest.of(page-1 ,rows, new Sort(Sort.Direction.DESC, "dayTime")));
        return new PageResult(list.getTotalElements(),list.getContent());
    }

    String parkName(JyStatement query) {
        return query.getPark() != null
                && StringUtils.isNotBlank(query.getPark().getParkName()) ? query.getPark().getParkName() : "";
    }
}
