package com.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.entity.Role;
import com.cloud.userservice.dao.RoleMapper;
import com.cloud.userservice.service.RolePermissionService;
import com.cloud.userservice.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author marco
 * @date 2020/11/15 2:42 下午
 */
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Role role) {
        // save role info
        boolean res = this.save(role);
        // associated permission
        rolePermissionService.addRolePermission(role.getId(), role.getPermissionId());
        return res;
    }

}
