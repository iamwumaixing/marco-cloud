package com.cloud.auth.service.impl;

import com.cloud.auth.provider.UserProvider;
import com.cloud.auth.service.RoleService;
import com.cloud.common.entity.Role;
import com.cloud.common.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author marco
 * @date 2020/11/14 6:49 下午
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private UserProvider userProvider;

    @Override
    public Set<String> getUserRolesByUserId(Integer userId) {
        return userProvider.getRolesByUserId(userId).getData();
    }
}
