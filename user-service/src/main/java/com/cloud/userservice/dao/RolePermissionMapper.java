package com.cloud.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author marco
 * @date 2020/11/15 3:01 下午
 */
@Mapper
@Repository
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
}
