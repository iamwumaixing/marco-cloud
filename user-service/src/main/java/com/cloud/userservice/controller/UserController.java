package com.cloud.userservice.controller;

import com.cloud.common.core.util.Result;
import com.cloud.common.entity.User;
import com.cloud.userservice.entity.dto.UserDto;
import com.cloud.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result add(@RequestBody @Valid UserDto userDto) {
        log.info("user add detail: {}", userDto);
        User user = userDto.toPo(User.class);
        return Result.ok(userService.add(user));
    }


}
