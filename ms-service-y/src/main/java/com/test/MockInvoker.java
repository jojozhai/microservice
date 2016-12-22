/*
 * 项目名称：ms-service-y
 * 类名称: MockInvoker
 * 创建时间: 2016年11月7日 上午10:30:12
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.web.client.RestTemplate;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
public class MockInvoker {
    
    public static void main(String[] args) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < 10000; i++) {
            System.out.println(restTemplate.getForObject("http://localhost:9899/greeting?name=1", String.class));
            Thread.sleep(100);
        }
    }

}
