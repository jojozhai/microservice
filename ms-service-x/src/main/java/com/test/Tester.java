/*
 * 项目名称：ms-service-x
 * 类名称: Tester
 * 创建时间: 2016年12月2日 上午9:11:06
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

import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
public class Tester {
    
    public static void main(String[] args) throws RestClientException, URISyntaxException {
        for (int j = 0; j < 200; j++) {
            try {
                String result = new RestTemplate().getForObject(new URI("http://localhost:7777/test3?name="+j), String.class);
                System.out.println(result);
            } catch (Exception e) {
                LoggerFactory.getLogger(Tester.class).info("errro", e);
                continue;
            }
            
        }
        
    }

}
