package com.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.entity.RolePermission;
import com.cloud.userservice.dao.RolePermissionMapper;
import com.cloud.userservice.service.RolePermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author marco
 * @date 2020/11/15 3:19 下午
 */
@Slf4j
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRolePermission(String roleId, Set<String> permissionId) {
        if (CollectionUtils.isEmpty(permissionId)) {
            return false;
        }
        // remove all
        removeByRoleId(roleId);
        Set<RolePermission> addRolePermission = permissionId.stream().map(pId -> new RolePermission(roleId, pId)).collect(Collectors.toSet());
        return saveBatch(addRolePermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByRoleId(String roleId) {
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(RolePermission::getRoleId, roleId);
        return remove(queryWrapper);
    }

    @Override
    public List<RolePermission> getByRoleIds(Set<String> roleIds) {
        QueryWrapper<RolePermission> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("role_id", roleIds);
        return this.list(queryWrapper);
    }

}
