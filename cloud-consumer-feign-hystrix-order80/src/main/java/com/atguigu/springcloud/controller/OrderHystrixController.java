package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ariel
 * @create 2020-03-10 22:26
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") int id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethd",commandProperties ={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    } )
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") int id) {
        return paymentHystrixService.paymentInfo_Timeout(id);
    }
    public String paymentTimeoutFallbackMethd(@PathVariable("id") int id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己，o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍候再试O(∩_∩)O哈哈~";
    }
}
