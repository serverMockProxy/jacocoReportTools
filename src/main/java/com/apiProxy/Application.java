package com.apiProxy;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@EnableAdminServer
@MapperScan({"com.apiProxy.mbg.mapper","com.apiProxy.dao"})
@EnableScheduling
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
