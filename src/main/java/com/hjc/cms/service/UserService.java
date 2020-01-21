package com.hjc.cms.service;

import com.hjc.cms.bean.User;

/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-02 15:03
 **/
public interface UserService {
    public User findByName(String userName);

}
