package com.toskey.cube.common.security;

import com.toskey.cube.common.security.component.CubeAccessDeniedHandler;
import com.toskey.cube.common.security.component.RedisAuthorizationService;
import com.toskey.cube.common.security.component.RedisRegisteredClientRepository;
import com.toskey.cube.common.security.service.PasswordUserDetailsServiceImpl;
import com.toskey.cube.common.security.service.SmsUserDetailsServiceImpl;
import com.toskey.cube.common.security.service.CubeUserDetailsService;
import com.toskey.cube.service.sas.interfaces.service.RemoteUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

/**
 * SecurityAutoConfiguration
 *
 * @author lis
 * @version 1.0
 * @description TODO
 * @date 2024/6/6 17:45
 */
public class SecurityAutoConfiguration {

    @Bean
    public CubeUserDetailsService passwordUserDetailsService(RedisTemplate<String, Object> redisTemplate,
                                                             RemoteUserService remoteUserService) {
        return new PasswordUserDetailsServiceImpl(redisTemplate, remoteUserService);
    }

    @Bean
    public CubeUserDetailsService smsUserDetailsService(RemoteUserService remoteUserService) {
        return new SmsUserDetailsServiceImpl(remoteUserService);
    }

    @Bean
    public CubeAccessDeniedHandler accessDeniedHandler() {
        return new CubeAccessDeniedHandler();
    }

    @Bean
    public OAuth2AuthorizationService redisAuthorizationService(RedisTemplate<String, Object> redisTemplate) {
        return new RedisAuthorizationService(redisTemplate);
    }

    @Bean
    public RegisteredClientRepository redisRegisteredClientRepository(RedisTemplate<String, Object> redisTemplate) {
        return new RedisRegisteredClientRepository(redisTemplate);
    }
}
