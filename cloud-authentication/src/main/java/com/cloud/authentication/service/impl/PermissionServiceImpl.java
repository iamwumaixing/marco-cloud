package com.cloud.authentication.service.impl;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.cloud.authentication.provider.PermissionProvider;
import com.cloud.authentication.service.NewMvcRequestMatcher;
import com.cloud.authentication.service.PermissionService;
import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author marco
 * @date 2020/12/6 7:10 下午
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionProvider permissionProvider;

    @Autowired
    private HandlerMappingIntrospector mvcHandlerMappingIntrospector;

    private static final Map<RequestMatcher, ConfigAttribute> RESOURCE_CONFIG_ATTRIBUTES = new HashMap<>();

    @Override
    public ConfigAttribute getConfigAttributeByUrl(HttpServletRequest request) {
        log.debug("资源池：{}", RESOURCE_CONFIG_ATTRIBUTES);
        String url = request.getParameter("url");
        String method = request.getParameter("method");
        return RESOURCE_CONFIG_ATTRIBUTES.keySet().stream()
                .filter(requestMatcher -> requestMatcher.equals(newMvcRequestMather(url, method)))
                .map(RESOURCE_CONFIG_ATTRIBUTES::get)
                .peek(urlConfigAttribute -> log.debug("url在资源池中配置：{}", urlConfigAttribute.getAttribute()))
                .findFirst()
                .orElse(new SecurityConfig("NONEXISTENT_URL"));
    }

    @Override
    public void loadResource() {
        Result<Set<Permission>> resourceResult = permissionProvider.resources();
        if (resourceResult.getCode() != 0) {
            System.exit(1);
        }
        Set<Permission> resources = resourceResult.getData();
        Map<MvcRequestMatcher, SecurityConfig> tempResourceConfigAttributes = resources.stream()
                .collect(Collectors.toMap(
                        resource -> this.newMvcRequestMather(resource.getUrl(), resource.getMethod()),
                        resource -> new SecurityConfig(resource.getPermissionName())
                ));
        RESOURCE_CONFIG_ATTRIBUTES.putAll(tempResourceConfigAttributes);
        log.debug("init resourceConfigAttributes: {}", RESOURCE_CONFIG_ATTRIBUTES);
    }

    @Override
    @Cached(name = "resource4user::", key = "#username", cacheType = CacheType.LOCAL)
    public Set<Permission> getByUsername(String username) {
        return permissionProvider.resources(username).getData();
    }

    /**
     * 创建 RequestMatcher
     *
     * @param url
     * @param method
     * @return
     */
    private MvcRequestMatcher newMvcRequestMather(String url, String method) {
        return new NewMvcRequestMatcher(mvcHandlerMappingIntrospector, url, method);
    }
}
