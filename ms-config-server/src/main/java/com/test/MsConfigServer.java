/*
 * 项目名称：ms-config-server
 * 类名称: MsConfigServer
 * 创建时间: 2016年11月2日 下午1:27:12
 * 创建人: zhailiang@pz365.com
 *
 * 修改历史:
 * 
 * Copyright: 2016 www.pz365.com Inc. All rights reserved.
 * 
 */
package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 *
 *
 * @author zhailiang@pz365.com
 * @version 1.0.0
 */
@SpringBootApplication
@EnableConfigServer
public class MsConfigServer {
    
    public static void main(String[] args) {
        SpringApplication.run(MsConfigServer.class, args);
    }

}
