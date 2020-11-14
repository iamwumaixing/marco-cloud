package com.cloud.userservice.service;

import java.util.Set;

/**
 * @author marco
 * @date 2020/11/12 6:30 下午
 */
public interface UserRoleService {

    /**
     * 用户添加角色
     *
     * @param userId
     * @param roleIds
     * @return
     */
    boolean addUserRole(Integer userId, Set<String> roleIds);

    /**
     * 删除用户拥有角色
     *
     * @param userId
     * @return
     */
    boolean removeByUserId(Integer userId);



}
