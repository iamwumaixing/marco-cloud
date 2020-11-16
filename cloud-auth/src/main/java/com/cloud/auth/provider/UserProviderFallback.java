package com.cloud.auth.provider;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Role;
import com.cloud.common.entity.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author marco
 * @date 2020/11/14 11:08 下午
 */
@Component
public class UserProviderFallback implements UserProvider {

    @Override
    public Result<User> getUserByUserName(String username) {
        return Result.ok(new User());
    }

    @Override
    public Result<Set<String>> getRolesByUserId(Integer userId) {
        return Result.ok(new HashSet<String>());
    }

}
