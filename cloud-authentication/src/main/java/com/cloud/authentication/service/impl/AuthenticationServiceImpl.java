package com.cloud.authentication.service.impl;

import com.cloud.authentication.service.AuthenticationService;
import com.cloud.authentication.service.PermissionService;
import com.cloud.common.entity.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author marco
 * @date 2020/11/22 2:29 上午
 */
@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     * 未在资源库中的URL默认标识
     */
    public static final String NONEXISTENT_URL = "NONEXISTENT_URL";

    @Autowired
    private PermissionServiceImpl permissionService;

    /**
     * @param request 访问的url, method
     * @return 有权限true, 无权限或全局资源中未找到请求url false
     */
    @Override
    public boolean permission(HttpServletRequest request) {
        log.info("To access the url: {}, method: {}", request.getServletPath(), request.getMethod());
        // get user auth info
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // get this url and method permission resource information
        ConfigAttribute urlConfigAttribute = permissionService.getConfigAttributeByUrl(request);
        if (NONEXISTENT_URL.equals(urlConfigAttribute.getAttribute())) {
            log.debug("url未在资源池中找到，拒绝访问");
        }
        Set<Permission> userResources = findResourcesByUsername(authentication.getName());
        // 用户拥有权限资源与url要求的资源进行对比
        return isMatch(urlConfigAttribute, userResources);
    }

    /**
     * url对应资源与用户拥有资源进行匹配
     *
     * @param urlConfigAttribute
     * @param userResources
     * @return
     */
    public boolean isMatch(ConfigAttribute urlConfigAttribute, Set<Permission> userResources) {
        return userResources.stream().anyMatch(resource -> resource.getPermissionName().equals(urlConfigAttribute.getAttribute()));
    }

    /**
     * 根据用户所被授予的角色，查询到用户所拥有到资源
     *
     * @param username
     * @return
     */
    private Set<Permission> findResourcesByUsername(String username) {
        // 用户被授予的角色资源
        Set<Permission> resources = permissionService.getByUsername(username);
        if (log.isDebugEnabled()) {
            log.debug("用户被授予角色的资源数量是:{}, 资源集合信息为:{}", resources.size(), resources);
        }
        return resources;
    }

}
