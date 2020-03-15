package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ariel
 * @create 2020-03-15 22:24
 */
@RestController
@Slf4j
public class PaymentNacosController
{
    @GetMapping("/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id")Long id){
        return "id = " + id+", serverPort = " + serverPort;
    }

    @Value("${server.port}")
    private String serverPort;
}
