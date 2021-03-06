package com.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.common.base.BaseEntity;
import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.*;

/**
 * @author marco
 * @date 2020/11/12 6:32 下午
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRole extends BaseEntity {

    private Integer userId;

    private String roleId;

}
