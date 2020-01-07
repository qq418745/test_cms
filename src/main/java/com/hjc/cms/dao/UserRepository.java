package com.hjc.cms.dao;

import com.hjc.cms.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    List<User> findByManager(int managerId);

    List<User> findByOpenId(String openId);
}
