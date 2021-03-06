package com.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.common.base.BaseEntity;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

/**
 * @author marco
 * @date 2020/11/12 12:14 上午
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean accountUnlocked;

    private String name;

    @TableField(exist = false)
    private Set<String> roleIds;

}
