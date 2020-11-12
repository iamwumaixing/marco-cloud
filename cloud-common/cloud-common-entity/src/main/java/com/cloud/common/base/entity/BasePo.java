package com.cloud.common.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author marco
 * @date 2020/11/12 12:55 上午
 */
@Data
public class BasePo implements Serializable {

    public final static String DEFAULT_USERNAME = "default";

    private Date createTime;

}
