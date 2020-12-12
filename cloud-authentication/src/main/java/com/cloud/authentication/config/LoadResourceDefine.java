package com.cloud.authentication.config;

import com.cloud.authentication.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author marco
 * @date 2020/11/22 4:03 下午
 */
@Component
public class LoadResourceDefine {

    @Autowired
    private PermissionService permissionService;

    /**
     * 初始化
     */
    @PostConstruct
    public void resourceConfigAttributes() {
        permissionService.loadResource();
    }


}
