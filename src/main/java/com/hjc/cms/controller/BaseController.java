package com.hjc.cms.controller;


import com.hjc.cms.bean.User;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.security.UserDetail;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.http.HttpServletRequest;


/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-03 11:35
 **/
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    enum BROWSER {IE, FIREFOX, CHROME}

    public static BROWSER getBrowser(HttpServletRequest request) {
        String userAgent = request.getHeader("USER-AGENT");
        if (StringUtils.isBlank(userAgent)) {
            return BROWSER.IE;
        }
        if (userAgent.contains("Chrome")) {
            return BROWSER.CHROME;
        }
        if (userAgent.contains("Firefox")) {
            return BROWSER.FIREFOX;
        }
        return BROWSER.IE;
    }


    //获取当前用户
    protected User currentUser() {
        UserDetail principal = (UserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal == null ? null :  principal.getUser();
    }


    //先调用用户是否管理 parkId方法
    protected String[]  currentUserParkIds() {
        User user = currentUser();

        if(isAdmin(user) ){
            return null;
        }
        return user.getRemark().split(";");
    }

   //超级管理员
    protected boolean isAdmin(User user) {
        return user.getId() == -10;
    }

    //是否拥有停车场管理权
   boolean userOwnershipPark () {
            User user = currentUser();
        return  isAdmin(user) || StringUtils.isNotBlank(user.getRemark()) ;
    }




    protected ExampleMatcher queryMatcher() {
        return ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    }


    protected PageRequest pageRequest(int page, int rows) {
        return  PageRequest.of(page - 1, rows);
    }

    protected PageRequest pageRequest(int page, int rows, Sort sort) {
        return new PageRequest(page - 1, rows, sort);
    }

    protected PageResult page(Page<?> data) {
        return new PageResult(data.getTotalElements(),data.getContent());
    }
}
