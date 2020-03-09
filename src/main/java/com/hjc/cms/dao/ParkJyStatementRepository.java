package com.hjc.cms.dao;

import com.hjc.cms.bean.JyStatement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.sql.Timestamp;

public interface ParkJyStatementRepository extends JpaRepository<JyStatement, Integer> {

    @Query("select p from JyStatement p where p.park.parkName like CONCAT('%',:parkName,'%')"+
            "and (p.dayTime >=:startTime or :startTime is null) " +
            "and (p.dayTime  <=:endTime or :endTime is null) "
            )
    Page<JyStatement> findAll(String parkName, Timestamp startTime, Timestamp endTime, Pageable pageable);

}