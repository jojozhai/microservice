/*
 * 项目名称：ms-service-x
 * 类名称: Config
 * 创建时间: 2016年11月4日 上午10:41:40
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@Configuration
public class Config {
    
    @Bean
    @LoadBalanced
    public RestTemplate xRestTemplate() {
        return new RestTemplate();
    }

}
