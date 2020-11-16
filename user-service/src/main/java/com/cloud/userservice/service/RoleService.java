package com.cloud.userservice.service;

import com.cloud.common.entity.Role;

import java.util.Set;

/**
 * @author marco
 * @date 2020/11/15 2:42 下午
 */
public interface RoleService {

    /**
     * 新增加角色
     *
     * @param role
     * @return
     */
    boolean add(Role role);

}
