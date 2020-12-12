package com.cloud.userservice.service;

import com.cloud.common.entity.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * @author marco
 * @date 2020/11/15 3:19 下午
 */
public interface RolePermissionService {

    /**
     * 角色增加权限
     *
     * @param roleId
     * @param permissionId
     * @return
     */
    boolean addRolePermission(String roleId, Set<String> permissionId);

    /**
     * 根据 roleId 删除所有权限
     *
     * @param roleId
     * @return
     */
    boolean removeByRoleId(String roleId);

    /**
     *
     * @param roleIds
     * @return
     */
    List<RolePermission> getByRoleIds(Set<String> roleIds);


}
