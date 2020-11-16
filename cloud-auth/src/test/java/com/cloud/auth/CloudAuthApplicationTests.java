package com.cloud.auth;

import com.cloud.auth.service.RoleService;
import com.cloud.auth.service.UserService;
import com.cloud.common.entity.Role;
import com.cloud.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class CloudAuthApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Test
    void contextLoads() {
        User user = userService.getByUserName("marco");
        System.out.println(user.toString());
    }

    @Test
    void getRoleByUserId() {
        Set<String> set = roleService.getUserRolesByUserId(4);
        set.forEach(role -> System.out.println(role.toString()));
    }

}
