package com.cloud.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器配置
 *
 * @author wmxing97
 * @date 2020/8/11 0:47
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * 对请求进行配置 规定指定的接口需要进行认证等功能
     *
     * @param http http请求
     * @throws Exception e
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // Since we want the protected resources to be accessible in the UI as well we need
                // session creation to be allowed (it's disabled by default in 2.0.6)
                // spring security 根据需要创建session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // 匹配任何请求
                .and().requestMatchers().anyRequest()
                // 允许匿名用户
                .and().anonymous()
                .and().authorizeRequests()
                //.antMatchers("/") permitAll 可以无需认证
                // 配置user路径访问控制，必须认证才可以访问
                .antMatchers("/user/**").authenticated();
    }
}
