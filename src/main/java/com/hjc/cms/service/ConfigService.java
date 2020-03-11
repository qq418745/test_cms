package com.hjc.cms.service;

import com.hjc.cms.bean.DynamicConf;
import com.hjc.cms.bean.entity.PageResult;


/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-03-02 14:07
 **/
public interface ConfigService {


    /**
     * 返回分页列表
     */
    public PageResult findPage(int pageNum, int pageSize);

    /**
     * 保存
     */
    public void save(DynamicConf dynamicConf);

    /**
     * 删除
     */
    public void delete(int id);

}
