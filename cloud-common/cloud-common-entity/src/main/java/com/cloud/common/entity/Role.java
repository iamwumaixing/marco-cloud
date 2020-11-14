package com.cloud.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author marco
 * @date 2020/11/12 12:14 上午
 */
@Data
@ToString
@NoArgsConstructor
@TableName("t_role")
public class Role {

    private Integer id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private String description;

}
