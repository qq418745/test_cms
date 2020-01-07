package com.hjc.cms.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.pojo.TbOrder;
import com.hjc.cms.dao.mapper.UserMapper;
import com.hjc.cms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: hjc_cms
 * @description:
 * @author: Mr.liuchengming
 * @create: 2020-01-03 09:47
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<TbOrder> findAll() {

        return userMapper.findAll();
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        Page<TbOrder> page=   (Page<TbOrder>) userMapper.findAll();
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public void add(TbOrder order) {

    }

    @Override
    public void update(TbOrder order) {

    }

    @Override
    public TbOrder findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public PageResult findPage(TbOrder order, int pageNum, int pageSize) {
        return null;
    }
}
