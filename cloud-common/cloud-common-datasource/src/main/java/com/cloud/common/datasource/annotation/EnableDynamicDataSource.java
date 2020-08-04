package com.cloud.common.datasource.annotation;

import com.cloud.common.datasource.DynamicDataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解-开启动态数据源
 *
 * @author wmxing97
 * @date 2020/8/4 3:14 下午
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicDataSourceAutoConfiguration.class)
public @interface EnableDynamicDataSource {

}
