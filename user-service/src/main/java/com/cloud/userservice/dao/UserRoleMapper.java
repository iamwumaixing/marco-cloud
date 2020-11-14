package com.cloud.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author marco
 * @date 2020/11/12 6:34 下午
 */
@Mapper
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {
}
