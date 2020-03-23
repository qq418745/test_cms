package com.hjc.cms.dao;

import com.hjc.cms.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-03 10:35
 **/
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    List<User> findByManager(int managerId);
    List<User> findByManagerNotNull();
    List<User> findByManagerIsNull();

    List<User> findByOpenId(String openId);
}
