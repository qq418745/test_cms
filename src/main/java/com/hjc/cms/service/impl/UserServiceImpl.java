package com.hjc.cms.service.impl;


import com.hjc.cms.bean.Dept;
import com.hjc.cms.bean.Mod;
import com.hjc.cms.bean.Role;
import com.hjc.cms.bean.User;
import com.hjc.cms.bean.entity.PageResult;
import com.hjc.cms.dao.DeptRepository;
import com.hjc.cms.dao.ModRepository;
import com.hjc.cms.dao.RoleRepository;
import com.hjc.cms.dao.UserRepository;
import com.hjc.cms.service.UserService;
import com.hjc.cms.utils.FwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * hjc_cms
 * Mr.liuchengming
 * 2020-01-02 15:04
 **/
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DeptRepository deptRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    ModRepository modRepository;

    @Override
    public User findByName(String userName) {
        return userRepository.findByName(userName);

    }

    @Override
    public PageResult findByPage(User user, int page, int rows) {
        Page<User> list = userRepository.findAll(Example.of(user, ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)), PageRequest.of(page-1, rows, new Sort(Sort.Direction.ASC, "id")));

        return new PageResult(list.getTotalElements(),list.getContent());
    }

    //private Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
    @Override
    @Transactional
    public void saveUser(User user) throws Exception {
        if (user.getId() == null
                || !user.getPassword().equals(

                userRepository.findById(user.getId()).orElse(null).getPassword())) {
            // new user or modify password
            user.setPassword(FwUtil.md5(user.getPassword()));
        }
        if (user.getDept() != null) {
            user.setDept(deptRepository.findById(user.getDept().getId()).orElse(null));
        }

        List<Role> roles = user.getRoles() != null ? user.getRoles().stream().map(
                role -> roleRepository.findById(role.getId()).orElse(null)).collect(Collectors.toList()) : new ArrayList<>();
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void saveRole(Role role, int deptId) throws Exception {
        Role record = role;
        if (role.getId() != null) {
             record = roleRepository.findById(role.getId()).orElse(null);
        }

        List<Mod> mods = new ArrayList<>();
        FwUtil.safeEach(role.getMods(), m -> mods.add(modRepository.findById(m.getId()).orElse(null)));
        record.setMods(mods);
        roleRepository.save(record);
        Dept dept = deptRepository.findById(deptId).orElse(null);
        FwUtil.replaceOrAddListItem(dept.getRoles(), record, (t, o) -> t.getId().equals(o.getId()));
        deptRepository.save(dept);
    }

    @Override
    public List<Mod> findAllMod() {
       return    modRepository.findAll();
    }
}
