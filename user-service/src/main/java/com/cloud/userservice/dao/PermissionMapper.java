package com.cloud.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author marco
 * @date 2020/12/6 7:34 下午
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
}
