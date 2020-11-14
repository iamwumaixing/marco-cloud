package com.cloud.common.datasource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wmxing97
 * @date 2020/8/4 3:23 下午
 */
@Data
@Component
@ConfigurationProperties("spring.datasource")
public class DataSourceProperties {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * jdbc url
     */
    private String url;

    /**
     * 驱动类型
     */
    private String driverClassName;

    /**
     * 查询数据源的SQL
     */
    private String queryDsSql = "select * from gen_datasource_conf where del_flag = 0";

}
