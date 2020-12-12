package com.cloud.authentication;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author marco
 */
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableCreateCacheAnnotation
public class CloudAuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudAuthenticationApplication.class, args);
	}

}
