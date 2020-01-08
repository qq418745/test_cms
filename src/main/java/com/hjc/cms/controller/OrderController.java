package com.hjc.cms.controller;

import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.bean.pojo.TOrder;
import com.hjc.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TOrder> findAll(){
        return orderService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult  findPage(int page,int rows){
        return orderService.findPage(page, rows);
    }

    /**
     * 增加
     * @param order
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TOrder order){
        try {
            orderService.add(order);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param order
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TOrder order){
        try {
            orderService.update(order);
            return new Result(true, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败");
        }
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TOrder findOne(String id){
        return orderService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(String [] ids){
        try {
            orderService.delete(ids);
      return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param order
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/search")
    public PageResult search(@RequestBody TOrder order, int page, int rows  ){
        return orderService.findPage(order, page, rows);
    }

}
