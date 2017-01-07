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

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * yyyyy
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
@RefreshScope
@EnableHystrixDashboard
public class ServiceY {
    
    public static void main(String[] args) {
        SpringApplication.run(ServiceY.class, args);
    }
    
    @Value("${y.test.value.1}")
    private String testValue;
    
    @Value("${server.port}")
    private String port;
    
    private Random random = new Random();
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceY.class);

    /**
     * xxxxxx
     * @param name
     * @return
     * @author zhailiang
     * @throws InterruptedException 
     * @since 2016年11月2日
     */
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @HystrixCommand
//    @HystrixCommand(fallbackMethod = "fallback")
    public String greeting(String name) throws InterruptedException {
        int randomInt= random.nextInt(10) ;
        LOGGER.info(name + ":"+ randomInt+"");
//        if(randomInt<8){  //模拟调用失败情况
//            throw new RuntimeException("call dependency service fail.");
//        }
        return "hello " + name+ ", "+port;
        
    }
    
    @RequestMapping(value = "/fallback", method = RequestMethod.GET)
    public String fallback(String name) {
        System.out.println("fallback!");
        return "fallback " + name+ ", "+port;
    }
    
    
    

}
