package com.cloud.common.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author marco
 * @date 2020/11/15 3:03 下午
 */
@Data
public class BaseEntity implements Serializable {

    protected Date createTime;

    protected Date updateTime;

}
