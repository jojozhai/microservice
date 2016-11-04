/*
 * 项目名称：ms-service-y
 * 类名称: ServiceY
 * 创建时间: 2016年11月2日 下午4:59:13
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * yyyyy
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ServiceY {
    
    public static void main(String[] args) {
        SpringApplication.run(ServiceY.class, args);
    }
    
    @Value("${y.test.value.1}")
    private String testValue;

    /**
     * xxxxxx
     * @param name
     * @return
     * @author zhailiang
     * @since 2016年11月2日
     */
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(String name) {
        System.out.println("invoke!!! "+testValue);
        return "hello " + name;
    }
    

}
