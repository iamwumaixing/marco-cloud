package com.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author marco
 * @date 2020/11/12 6:32 下午
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_role")
public class UserRole {

    private Integer userId;

    private String roleId;

}
