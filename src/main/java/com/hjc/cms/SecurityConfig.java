package com.hjc.cms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;



/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2019-12-31 17:17
 **/
@EnableWebSecurity
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置

public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl UserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**", "/img/**","/plugins/**").permitAll();
        //super.configure(http);
        http
                .formLogin().loginPage("/login").loginProcessingUrl("/login-check").failureUrl("/login?error=true").permitAll()  //表单登录，permitAll()表示这个不需要验证 登录页面，登录失败页面
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();//关闭CSRF
        http
                .headers().frameOptions().sameOrigin();//放frame

        //开启自动配置的注销功能，会访问/logout请求
        http.logout().logoutSuccessUrl("/"); //注销成功后，回到首页

        /*开启记住我功能（开启后，springboot会给浏览器发送一个cookies，以后访问网站都会带上这个cookies给springboot验证，springboot会检查以前某一个用户的cookies的值是什么，如果找到了，这个用户就不用再次登录了，注销时候springboot会发送命令给浏览器删除cookies）*/
        http.rememberMe();


//        .formLogin()
//                .and()
//                .csrf().disable()
//                .formLogin().loginPage("/login")
//                .loginProcessingUrl("/form")
//                .defaultSuccessUrl("/index") //成功登陆后跳转页面
//                .failureUrl("/loginError").permitAll();

    }





    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(UserDetailsService);

        auth.authenticationProvider(authProvider);
    }

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }







}
