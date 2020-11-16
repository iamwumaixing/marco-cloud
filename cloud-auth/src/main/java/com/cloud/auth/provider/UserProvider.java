package com.cloud.auth.provider;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Role;
import com.cloud.common.entity.User;
import com.cloud.common.entity.UserRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * @author marco
 * @date 2020/11/14 11:07 下午
 */
@FeignClient(name = "user-service", fallback = UserProviderFallback.class)
public interface UserProvider {

    /**
     * 获取user信息
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/user/get/{username}")
    Result<User> getUserByUserName(@PathVariable("username") String username);

    /**
     * 根据userId获取对应roleId
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/role/user/{userId}")
    Result<Set<String>> getRolesByUserId(@PathVariable("userId") Integer userId);
}
