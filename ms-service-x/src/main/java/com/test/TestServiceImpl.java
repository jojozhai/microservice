/*
 * 项目名称：ms-service-x
 * 类名称: TestServiceImpl
 * 创建时间: 2016年11月4日 上午10:26:34
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private ServiceYInvoker serviceYInvoker;
    
    @Override
    public String greeting(String name) {
        return serviceYInvoker.greeting(name);
    }

}
