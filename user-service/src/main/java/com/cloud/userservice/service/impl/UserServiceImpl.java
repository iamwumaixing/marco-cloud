package com.cloud.userservice.service.impl;

import com.cloud.common.entity.User;
import com.cloud.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author marco
 * @date 2020/11/12 12:25 上午
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean add(User user) {
        log.info("user: {}", user);
        return true;
    }

}
