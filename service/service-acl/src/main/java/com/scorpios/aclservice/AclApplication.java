package com.scorpios.aclservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient // 注册nacos
@EnableFeignClients // 远程调用
@ComponentScan(basePackages = {"com.scorpios"})
public class AclApplication {

    public static void main(String[] args) {
        SpringApplication.run(AclApplication.class,args);
    }
}
