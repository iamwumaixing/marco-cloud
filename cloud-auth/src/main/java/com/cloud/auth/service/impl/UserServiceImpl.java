package com.cloud.auth.service.impl;

import com.cloud.auth.provider.UserProvider;
import com.cloud.auth.service.UserService;
import com.cloud.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author marco
 * @date 2020/11/14 6:48 下午
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProvider userProvider;

    @Override
    public User getByUserName(String username) {
        return userProvider.getUserByUserName(username).getData();
    }

}
