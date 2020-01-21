package com.hjc.cms;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import javax.sql.DataSource;


/**
 * hjc_cms
 * SpringBoot引导类
 * Mr.liuchengming
 * 2019-12-19 12:00
 **/
@SpringBootApplication
@MapperScan("com.hjc.cms.dao.mapper")
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }

    /**
     * 设置匹配.do后缀的请求
     * @param dispatcherServlet
     * @return
     */
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
//        ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
//        bean.addUrlMappings("*.do");
//        return bean;
//    }


    @Bean("druidDataSource")
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidDataSource() { return new DruidDataSource(); }
}
