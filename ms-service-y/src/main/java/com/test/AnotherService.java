/*
 * 项目名称：ms-service-y
 * 类名称: AnotherService
 * 创建时间: 2016年11月3日 上午8:58:03
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@RestController
public class AnotherService {
    
    @RequestMapping(value = "/greetingxxx", method = RequestMethod.GET)
    public String greeting(String name) {
        return "hello " + name;
    }

}
