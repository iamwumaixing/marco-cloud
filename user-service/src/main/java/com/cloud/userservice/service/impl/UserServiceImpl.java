package com.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.entity.User;
import com.cloud.userservice.dao.UserMapper;
import com.cloud.userservice.service.UserRoleService;
import com.cloud.userservice.service.UserService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author marco
 * @date 2020/11/12 12:25 上午
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserRoleService userRoleService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Transactional
    public boolean add(User user) {
        log.info("user: {}", user);
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(passwordEncoder().encode(user.getPassword()));
        }
        boolean res = this.save(user);
        userRoleService.addUserRole(user.getId(), user.getRoleIds());
        return res;
    }



}
