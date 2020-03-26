package com.hjc.cms.controller;


import com.hjc.cms.bean.Role;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.bean.entity.Result;
import com.hjc.cms.dao.RoleRepository;
import com.hjc.cms.dao.UserRepository;
import com.hjc.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("role")
public class RoleController extends BaseController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

//    @RequestMapping("obtainUserRoles")
//    @ResponseBody
//    public List<Role> obtainUserRoles(int userId) {
//        return userRepository.findOne(userId).getRoles();
//    }

    @RequestMapping("findPage")
    @ResponseBody
    public PageResult obtainRoles(int page, int rows) {
        Page<Role> roles = roleRepository.findAll(pageRequest(page, rows));
        return new PageResult(roles.getTotalElements(),roles.getContent());
    }

//    @RequestMapping("deleteRole")
//    @ResponseBody
//    public String deleteRole(int[] roleIds) {
//        for (int id : roleIds) {
//            roleRepository.delete(id);
//        }
//        return DONE;
//    }
//
    @RequestMapping("save")
    public Result save(@RequestBody Role role, int deptId) throws Exception {
        userService.saveRole(role, deptId);
        return  new Result(true,"请求成功");
    }
}