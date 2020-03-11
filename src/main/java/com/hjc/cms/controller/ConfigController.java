package com.hjc.cms.controller;

import com.hjc.cms.bean.DynamicConf;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-03-02 14:35
 */
@RestController
@RequestMapping("conf")
public class ConfigController extends BaseController {


    @Autowired
    ConfigService configService;

    @RequestMapping("findPage")
    public PageResult obtainConfigs(int page, int rows) {
      return    configService.findPage(page,rows);

    }

    @RequestMapping("delete")
    public Result deleteConfig(int confId) {
        configService.delete(confId);
        return new Result(true,"删除成功");
    }

    @RequestMapping("save")
    public Result saveConfig(@RequestBody DynamicConf conf) throws Exception {
        configService.save(conf);
        //Conf.triggerChangeListeners(conf.getConfName());
        return  new Result(true,"保存成功");
    }
}
