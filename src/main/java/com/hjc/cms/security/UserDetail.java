package com.hjc.cms.security;


//import com.hjc.cms.bean.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;

/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-14 21:19
 **/
public class UserDetail  extends User {

    private com.hjc.cms.bean.User user;

    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,com.hjc.cms.bean.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public com.hjc.cms.bean.User getUser() {
        return this.user;
    }
}

