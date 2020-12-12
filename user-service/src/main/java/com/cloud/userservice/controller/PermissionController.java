package com.cloud.userservice.controller;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Permission;
import com.cloud.userservice.entity.dto.PermissionDTO;
import com.cloud.userservice.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.util.List;
import java.util.Set;

/**
 * @author marco
 * @date 2020/12/6 7:27 下午
 */
@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/all")
    public Result getAll() {
        List<Permission> permissionSet = permissionService.getAll();
        return Result.ok(permissionSet);
    }

    @GetMapping("/user/{username}")
    public Result getByUsername(@PathVariable("username") String username) {
        List<Permission> permissionSet = permissionService.getByUsername(username);
        return Result.ok(permissionSet);
    }

    @PostMapping("/add")
    public Result add(PermissionDTO permissionDTO) {
        boolean res = permissionService.add(PermissionDTO.convertToPo(permissionDTO));
        return Result.ok(res);
    }
}
