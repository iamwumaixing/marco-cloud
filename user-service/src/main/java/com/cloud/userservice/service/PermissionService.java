package com.cloud.userservice.service;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Permission;

import java.util.List;
import java.util.Set;

/**
 * @author marco
 * @date 2020/12/6 7:26 下午
 */
public interface PermissionService {

    /**
     * 获取全部接口权限
     *
     * @return
     */
    List<Permission> getAll();

    /**
     * 获取指定username权限
     *
     * @param username
     * @return
     */
    List<Permission> getByUsername(String username);

    /**
     * 新增资源权限
     *
     * @param permission
     * @return
     */
    boolean add(Permission permission);

}
