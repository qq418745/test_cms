package com.hjc.cms.controller;


import com.hjc.cms.bean.JyStatement;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.service.ParkJyStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Timestamp;


/**
 * cms_hjc
 * Mr.liuchengming
 * 2019-08-23 13:50
 **/
@Controller
@RequestMapping("parkStatement")
public class ParkJyStatementController extends BaseController {

    @Autowired
    ParkJyStatementService parkJyStatementService;


    @RequestMapping("search")
    @ResponseBody
    public PageResult search(@RequestBody JyStatement jyStatement,/* Timestamp startTime, Timestamp endTime, */int page, int rows) {
        PageResult pageResult =  parkJyStatementService.findPage(jyStatement,null,null,page,rows);
        return pageResult;
    }

//    String[] parkId() {
//        User user = currentUser();
//        if (user == null || isAdmin(user) || isEmpty(user.getRemark())) {
//            return parkCached.findAll().stream().map(Park::getParkId).toArray(String[]::new);
//        }
//        return user.getRemark().split(";");
//    }

}
