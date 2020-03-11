package com.hjc.cms.service.impl;


import com.hjc.cms.bean.DynamicConf;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.ConfRepository;
import com.hjc.cms.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



/**
 * hjc_cms
 * info:
 * Mr.liuchengming
 * 2020-03-02 14:14
 **/
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfRepository confRepository;


    @Override
    public PageResult findPage(int page, int limit) {
        Page<DynamicConf> list = confRepository.findAll(PageRequest.of(page-1 ,limit));
        return new PageResult(list.getTotalElements(),list.getContent());
    }

    @Override
    public void save(DynamicConf dynamicConf) {
         confRepository.save(dynamicConf);
    }

    @Override
    public void delete(int id) {
        confRepository.deleteById(id);
    }
}
