package com.hjc.cms.service;


import com.hjc.cms.bean.Role;
import com.hjc.cms.bean.User;
import com.hjc.cms.bean.entity.PageResult;


/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-02 15:03
 **/
public interface UserService {


    public User findByName(String userName);

    public PageResult findByPage(User user, int page, int rows);

    public  void saveUser(User user) throws Exception;

    public  void saveRole(Role role, int deptId) throws Exception;


}
