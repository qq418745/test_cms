package com.hjc.cms.controller;

import com.hjc.cms.bean.Dept;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by xd on 2016/12/14.
 */
@RestController
@RequestMapping("dept")
public class DeptController extends BaseController {
    @Autowired
    DeptRepository deptRepository;
//    @Autowired
//    CachedRepository cachedRepository;

    @RequestMapping("findPage")
    @ResponseBody
    public PageResult obtainDepts(int page, int rows) {
        Page<Dept> depts = deptRepository.findAll(pageRequest(page, rows, new Sort(Sort.Direction.ASC, "id")));
        return page(depts);
    }

//    @RequestMapping("obtainAllDepts")
//    @ResponseBody
//    public List<Dept> obtainAllDepts() {
//        return cachedRepository.findAllDept();
//    }
}
