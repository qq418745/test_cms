package com.hjc.cms.service.impl;

import com.hjc.cms.bean.User;
import com.hjc.cms.dao.UserRepository;
import com.hjc.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-02 15:04
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByName(String userName) {
        return userRepository.findByName(userName);

    }
}
