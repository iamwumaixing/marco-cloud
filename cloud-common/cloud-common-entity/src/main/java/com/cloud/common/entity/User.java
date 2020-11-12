package com.cloud.common.entity;

import com.cloud.common.base.entity.BasePo;
import lombok.*;

/**
 * @author marco
 * @date 2020/11/12 12:14 上午
 */

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BasePo {

    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean accountUnlocked;

    private String name;

}
