package com.cloud.authentication.provider;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author marco
 * @date 2020/12/6 7:13 下午
 */
@Slf4j
@Component
public class PermissionProviderFallback implements PermissionProvider {

    @Override
    public Result<Set<Permission>> resources() {
        log.error("认证服务启动时加载资源异常，加载资源失败");
        return Result.failed();
    }

    @Override
    public Result<Set<Permission>> resources(String username) {
        log.error("认证服务查询用户异常，查询用户资源为空");
        return Result.ok(new HashSet<Permission>());
    }

}
