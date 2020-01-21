package com.hjc.cms.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * hjc_cms
 * 密码校验方式
 * Mr.liuchengming
 * 2020-01-02 16:20
 **/
public class Md5PasswordEncoder  implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return DigestUtils.md5Hex((String) charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String encodedPassword) {
        return encodedPassword.equals(DigestUtils.md5Hex((String) charSequence)) ;
    }
}
