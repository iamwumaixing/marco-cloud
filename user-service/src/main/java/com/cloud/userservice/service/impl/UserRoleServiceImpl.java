package com.cloud.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.common.entity.UserRole;
import com.cloud.userservice.dao.UserRoleMapper;
import com.cloud.userservice.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author marco
 * @date 2020/11/12 6:30 下午
 */
@Slf4j
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    @Transactional
    public boolean addUserRole(Integer userId, Set<String> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            return false;
        }
        removeByUserId(userId);
        Set<UserRole> userRoles = roleIds.stream().map(roleId -> new UserRole(userId, roleId)).collect(Collectors.toSet());
        return saveBatch(userRoles);
    }

    @Override
    @Transactional
    public boolean removeByUserId(Integer userId) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserRole::getUserId, userId);
        return remove(queryWrapper);
    }



}
