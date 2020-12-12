package com.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.common.base.BaseEntity;
import lombok.*;

/**
 * @author marco
 * @date 2020/11/15 3:02 下午
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_permission")
@EqualsAndHashCode(callSuper = false)
public class Permission extends BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    private String permissionName;

    private String url;

    private String method;

    private String description;

}
