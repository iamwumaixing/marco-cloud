package com.cloud.authentication.controller;

import com.cloud.authentication.service.AuthenticationService;
import com.cloud.common.core.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author marco
 * @date 2020/11/22 2:25 上午
 */
@Slf4j
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/auth/permission")
    public Result verify(@RequestParam String url, @RequestParam String method, HttpServletRequest request) {
        HttpServletRequest httpServletRequest = new HttpServletRequestAuthWrapper(request, url, method);
        boolean permission = authenticationService
                .permission(httpServletRequest);
        return Result.ok(permission);
    }


}
