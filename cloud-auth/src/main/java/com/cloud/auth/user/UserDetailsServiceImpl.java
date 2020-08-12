package com.cloud.auth.user;

import com.cloud.auth.util.PasswordEncoderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wmxing97
 * @date 2020/8/9 23:59
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * 先用数组代替数据库存储用户信息
     */
    private List<User> userList;

    @PostConstruct
    public void initData() {
        // {bcrypt} -> BCryptPasswordEncoder -> 标明密码的加密方式 -> {bcrypt} = BCryptPasswordEncoder加密
        // {bcrypt} is just a configuration and not a part of the password
        String password = "{bcrypt}" + PasswordEncoderUtil.encode("123456");
        userList = new ArrayList<>();
        userList.add(new User("marco", password, AuthorityUtils.commaSeparatedStringToAuthorityList("USER")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> findUserList =
                userList.stream().filter(user -> user.getUsername().equals(username)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(findUserList)) {
            return findUserList.get(0);
        } else {
            throw new UsernameNotFoundException("用户名不存在!");
        }
    }

}
