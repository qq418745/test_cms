package com.hjc.cms.controller;

import com.hjc.cms.IConst;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TOrder;
import com.hjc.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-01-03 10:35
 **/
@RestController
@RequestMapping("order")
public class OrderController  extends  BaseController implements IConst  {

     @Autowired
     OrderService orderService;
    /**
     * 获取实体
     */
    @RequestMapping("/findOne")
    public TOrder findOne(String id){
        return orderService.findOne(id);
    }

    /**
     * 查询+分页
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TOrder order,String startTimeStamp,String outTimeStamp, int page, int rows  ) throws Exception {

        return orderService.findPage(order,startTimeStamp,outTimeStamp, page, rows,currentUserParkIds());
    }

    /**
     * 日月年报表查询+分页
     * exportType  报表类型  1 = 日报 2 = 月报  3 = 年报
     */
    @RequestMapping("/get-report-data")
    public PageResult getReportData(@RequestBody TOrder tOrder,String startTimeStamp , String outTimeStamp,Integer exportType,int[] payFlags,boolean payFlagsNotIn,int page, int rows){
        PageResult report = orderService.findReport(tOrder, startTimeStamp, outTimeStamp, exportType, payFlags,payFlagsNotIn,page, rows);
        return  report;
    }

}
