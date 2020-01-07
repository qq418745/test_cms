package com.hjc.cms.service;

import com.hjc.cms.bean.User;

/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-02 15:03
 **/
public interface UserService {
    public User findByName(String userName);

}
