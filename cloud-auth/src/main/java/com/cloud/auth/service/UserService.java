package com.cloud.auth.service;

import com.cloud.common.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author marco
 * @date 2020/11/14 6:36 下午
 */
@Service
public interface UserService {

    /**
     * 根据用户唯一标识获取用户信息
     *
     * @param username
     * @return
     */
    @Cacheable(value = "#username")
    User getByUserName(String username);


}
