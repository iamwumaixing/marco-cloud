package com.cloud.auth.service;

import com.cloud.common.entity.Role;
import com.cloud.common.entity.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author marco
 * @date 2020/11/14 6:42 下午
 */
@Service
public interface RoleService {

    /**
     * 根据userId获取该user角色集合
     *
     * @param userId
     * @return
     */
    Set<String> getUserRolesByUserId(Integer userId);

}
