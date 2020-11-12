package com.cloud.common.entity;

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
public class User {

    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

    private Boolean accountUnlocked;

    private String name;

}
