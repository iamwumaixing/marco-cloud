package com.cloud.common.datasource;

import com.baomidou.dynamic.datasource.processor.DsProcessor;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.cloud.common.datasource.config.DataSourceProperties;
import com.cloud.common.datasource.config.JdbcDynamicDataSourceProvider;
import com.cloud.common.datasource.config.LastParamDsProcessor;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wmxing97
 * @date 2020/8/4 3:11 下午
 */
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
@EnableConfigurationProperties(DataSourceProperties.class)
public class DynamicDataSourceAutoConfiguration {

    private final StringEncryptor stringEncryptor;

    private final DataSourceProperties properties;

    @Bean
    public DynamicDataSourceProvider dynamicDataSourceProvider() {
        return new JdbcDynamicDataSourceProvider(stringEncryptor, properties);
    }

    @Bean
    public DsProcessor dsProcessor() {
        return new LastParamDsProcessor();
    }




}
