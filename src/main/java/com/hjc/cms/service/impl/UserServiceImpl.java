package com.hjc.cms.service.impl;


import com.hjc.cms.bean.User;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.UserRepository;
import com.hjc.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-02 15:04
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByName(String userName) {
        return userRepository.findByName(userName);

    }

    @Override
    public PageResult findByPage(User user, int page, int rows) {
        Page<User> list = userRepository.findAll(Example.of(user, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), PageRequest.of(page-1, rows, new Sort(Sort.Direction.ASC, "id")));

        return new PageResult(list.getTotalElements(),list.getContent());
    }
}
