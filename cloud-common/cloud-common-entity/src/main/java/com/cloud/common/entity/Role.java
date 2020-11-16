package com.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.awt.*;
import java.util.Date;
import java.util.Set;

/**
 * @author marco
 * @date 2020/11/12 12:14 上午
 */
@Data
@ToString
@NoArgsConstructor
@TableName("t_role")
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    private String roleName;

    private String description;

    @TableField(exist = false)
    private Set<String> permissionId;

}
