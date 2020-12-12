package com.cloud.authentication.provider;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Permission;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

/**
 * @author marco
 * @date 2020/12/6 7:13 下午
 */
@FeignClient(name = "user-service", fallback = PermissionProviderFallback.class)
public interface PermissionProvider {

    /**
     * 获取所有权限资源列表
     *
     * @return
     */
    @GetMapping(value = "/permission/all")
    Result<Set<Permission>> resources();

    /**
     * 获取用户所有权限资源列表
     *
     * @param username
     * @return
     */
    @GetMapping(value = "/permission/user/{username}")
    Result<Set<Permission>> resources(@PathVariable("username") String username);

}
