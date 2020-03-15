package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ariel
 * @create 2020-03-14 23:37
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3355 {
    public static void main(String[] args){
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
