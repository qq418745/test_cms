package com.hjc.cms.dao;

import com.hjc.cms.bean.DynamicConf;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConfRepository extends JpaRepository<DynamicConf, Integer> {
}