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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@RestController
public class TestController {
    
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test")
    public String test(String name) {
        return testService.greeting(name);
    }
    
}
