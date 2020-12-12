package com.cloud.authentication.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author marco
 * @date 2020/11/22 2:29 上午
 */
@Service
public interface AuthenticationService {

    /**
     * 权限验证
     *
     * @param request
     * @return 是否有相应权限
     */
    boolean permission(HttpServletRequest request);

}
