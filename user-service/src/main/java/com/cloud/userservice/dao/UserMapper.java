package com.cloud.userservice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author marco
 * @date 2020/11/12 6:18 下午
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
