package com.hjc.cms.dao;

import com.hjc.cms.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DeptRepository extends JpaRepository<Dept, Integer> {
    Dept findByName(String name);
}