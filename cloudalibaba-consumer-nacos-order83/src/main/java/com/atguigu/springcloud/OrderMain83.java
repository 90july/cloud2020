package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ariel
 * @create 2020-03-15 22:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain83
{
    public static void main(String[] args){
        SpringApplication.run(OrderMain83.class,args);
    }
}