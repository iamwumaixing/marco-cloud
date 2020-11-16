package com.cloud.userservice.controller;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.User;
import com.cloud.userservice.entity.dto.UserDTO;
import com.cloud.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author marco
 * @date 2020/11/12 12:24 上午
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid UserDTO userDto) {
        log.info("user add detail: {}", userDto);
        User user = UserDTO.convertToPo(userDto);
        return Result.ok(userService.add(user));
    }

    @GetMapping("/get/{username}")
    public Result getByUserName(@PathVariable String username) {
        log.info("query with username: {}", username);
        User user = userService.getByUserName(username);
        return Result.ok(user);
    }


}
