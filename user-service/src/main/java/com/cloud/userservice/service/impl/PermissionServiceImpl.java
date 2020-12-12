package com.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.entity.Permission;
import com.cloud.common.entity.Role;
import com.cloud.common.entity.RolePermission;
import com.cloud.common.entity.User;
import com.cloud.userservice.dao.PermissionMapper;
import com.cloud.userservice.service.PermissionService;
import com.cloud.userservice.service.RolePermissionService;
import com.cloud.userservice.service.RoleService;
import com.cloud.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author marco
 * @date 2020/12/6 7:26 下午
 */
@Slf4j
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    RolePermissionService rolePermissionService;

    @Override
    public List<Permission> getAll() {
        return this.list();
    }

    @Override
    public List<Permission> getByUsername(String username) {
        // get user info
        User user = userService.getByUserName(username);
        // get user roles
        List<Role> roles = roleService.getRoleByUserId(user.getId());
        Set<String> roleIds = roles.stream().map(Role::getId).collect(Collectors.toSet());
        // get permission by roles
        List<RolePermission> rolePermissions = rolePermissionService.getByRoleIds(roleIds);
        Set<String> permissionIds = rolePermissions.stream().map(RolePermission::getPermissionId).collect(Collectors.toSet());
        return this.listByIds(permissionIds);
    }

    @Override
    public boolean add(Permission permission) {
        return this.save(permission);
    }

}
