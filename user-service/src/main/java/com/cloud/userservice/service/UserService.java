package com.cloud.userservice.service;

import com.cloud.common.entity.User;

/**
 * @author marco
 * @date 2020/11/12 12:25 上午
 */
public interface UserService {

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    boolean add(User user);
}
