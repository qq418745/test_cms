package com.hjc.cms.controller;

import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-03 10:35
 **/
@RestController
@RequestMapping("order")
public class OrderController {

     @Autowired
     OrderService orderService;

    @RequestMapping("/findAll")
    public PageResult findAll(int page,int rows){

        return  orderService.findPage(page, rows);

    }

}
