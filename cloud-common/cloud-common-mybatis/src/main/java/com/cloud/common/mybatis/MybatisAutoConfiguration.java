package com.cloud.common.mybatis;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis plus 统一配置类
 *
 * @author wmxing97
 * @date 2020/8/4 4:53 下午
 */
@Configuration(proxyBeanMethods = false)
public class MybatisAutoConfiguration {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
