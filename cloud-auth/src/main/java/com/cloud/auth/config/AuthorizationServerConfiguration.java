package com.cloud.auth.config;

import com.cloud.auth.user.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * 认证服务器配置
 *
 * @author wmxing97
 * @date 2020/8/9 22:45
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // 最顶层权限管理器
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .authenticationManager(authenticationManager)
                // 根据用户名获取用户的详细信息
                .userDetailsService(userDetailsService)
                // token存储位置 - redis
                .tokenStore(tokenStore);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置了两个客户端 -> password模式认证 和 client模式认证
        clients.inMemory().withClient("client_1")
                .resourceIds("user")
                .authorizedGrantTypes("client_credentials","refresh_token")
                .scopes("select")
                .authorities("client")
                .secret("{noop}123456")
                .and().withClient("client_2")
                .resourceIds("user")
                .authorizedGrantTypes("password","refresh_token")
                .scopes("select")
                .authorities("client")
                // {noop} -> NoOpPasswordEncoder -> 标明了该处是什么类型加密的 noop = 无需加密
                // {noop} is just a configuration and not a part of the password
                .secret("{noop}123456");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                // 允许表单认证
                .allowFormAuthenticationForClients();
    }
}
