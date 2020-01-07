package com.hjc.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * @program: hjc_cms
 * @description: SpringBoot引导类
 * @author: Mr.liuchengming
 * @create: 2019-12-19 12:00
 **/
@SpringBootApplication
@MapperScan("com.hjc.cms.dao.mapper")
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }
}
