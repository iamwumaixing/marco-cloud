package com.cloud.userservice.controller;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.Role;
import com.cloud.userservice.entity.dto.RoleDTO;
import com.cloud.userservice.service.RoleService;
import com.cloud.userservice.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author marco
 * @date 2020/11/15 12:52 上午
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid RoleDTO roleDTO) {
        log.info("add role: {}", roleDTO);
        Role role = RoleDTO.convertToPo(roleDTO);
        return Result.ok(roleService.add(role));
    }

    @GetMapping("/user/{userId}")
    public Result getRolesByUserId(@PathVariable Integer userId) {
        return Result.ok(userRoleService.getByUserId(userId));
    }

}
