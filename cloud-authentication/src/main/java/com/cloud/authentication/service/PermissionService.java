package com.cloud.authentication.service;

import com.cloud.common.entity.Permission;
import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author marco
 * @date 2020/12/6 7:09 下午
 */
public interface PermissionService {

    /**
     * 根据url和method查询到对应的权限信息
     *
     * @param request
     * @return
     */
    ConfigAttribute getConfigAttributeByUrl(HttpServletRequest request);

    /**
     * 加载资源
     */
    void loadResource();

    /**
     * get resource by username
     *
     * @param username
     * @return
     */
    Set<Permission> getByUsername(String username);
}
