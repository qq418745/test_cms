//package com.hjc.cms.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import xd.fw.bean.Dept;
//import xd.fw.dao.CachedRepository;
//import xd.fw.dao.DeptRepository;
//
//import java.util.List;
//
///**
// * Created by xd on 2016/12/14.
// */
//@Controller
//@RequestMapping("dept")
//public class DeptController extends BaseController {
//    @Autowired
//    DeptRepository deptRepository;
//    @Autowired
//    CachedRepository cachedRepository;
//
//    @RequestMapping("obtainDepts")
//    @ResponseBody
//    public PageContent obtainDepts(int page, int limit) {
//        return page(deptRepository.findAll(pageRequest(page, limit, new Sort(Sort.Direction.ASC, "id"))));
//    }
//
//    @RequestMapping("obtainAllDepts")
//    @ResponseBody
//    public List<Dept> obtainAllDepts() {
//        return cachedRepository.findAllDept();
//    }
//}
