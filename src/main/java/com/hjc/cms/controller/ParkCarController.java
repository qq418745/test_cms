package com.hjc.cms.controller;

import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.bean.pojo.TParkCar;

import com.hjc.cms.service.ParkCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by Mr.wayne on 2020/1/9 16:39.
 */
@RestController
@RequestMapping("parkCar")
public class ParkCarController {

     @Autowired
     ParkCarService parkCarService;

    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<TParkCar> findAll(){
        return parkCarService.findAll();
    }


    /**
     * 返回全部列表
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult  findPage(int page,int rows){
        return parkCarService.findPage(page, rows);
    }

    /**
     * 增加
     * @param parkCar
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TParkCar parkCar){
        try {
            parkCarService.add(parkCar);
            return new Result(true, "增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "增加失败");
        }
    }

    /**
     * 修改
     * @param parkCar
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TParkCar parkCar){
        try {
            parkCarService.update(parkCar);
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
    public TParkCar findOne(String id){
        return parkCarService.findOne(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(String [] ids){
        try {
            parkCarService.delete(ids);
      return new Result(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败");
        }
    }

    /**
     * 查询+分页
     * @param parkCar
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("search")
    public PageResult search(@RequestBody TParkCar parkCar, int page, int rows  ){
        return parkCarService.findPage(parkCar, page, rows);
    }

}
