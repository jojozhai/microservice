/*
 * 项目名称：ms-service-x
 * 类名称: TestController
 * 创建时间: 2016年11月4日 上午10:25:33
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@RestController
public class TestController {
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Autowired
    private RestTemplate xRestTemplate;
    
    @Autowired
    private ServiceYInvoker serviceYInvoker;
    
    @RequestMapping(value = "/test1")
    public String test1(String name) throws RestClientException, URISyntaxException {
        
        String serviceLocation = discoveryClient.getInstances("servicey").get(0).getUri().toString();
        
        String serviceUri = String.format("%s/greeting?name=%s", serviceLocation, name);
        
        return new RestTemplate().getForObject(new URI(serviceUri), String.class);
    }
    
    @RequestMapping(value = "/test2")
    public String test2(String name) throws RestClientException, URISyntaxException {
        return xRestTemplate.getForObject(new URI("http://servicey/greeting?name="+name), String.class);
    }

    @RequestMapping(value = "/test3")
//    @HystrixCommand(threadPoolKey = "testPookKey", threadPoolProperties = {
//            @HystrixProperty(name = "coreSize", value = "30"),
//            @HystrixProperty(name = "maxQueueSize", value = "10"),
//    })
    public String test3(String name) {
        return serviceYInvoker.greeting(name);
    }
    
}
