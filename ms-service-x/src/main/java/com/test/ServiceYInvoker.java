/*
 * 项目名称：ms-service-x
 * 类名称: ServiceYInvoker
 * 创建时间: 2016年11月4日 上午10:51:14
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@FeignClient("servicey")
public interface ServiceYInvoker {

    @RequestMapping(method = RequestMethod.GET, value="/greeting")
    String greeting(@RequestParam("name") String name);

}
