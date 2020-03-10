package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ariel
 * @create 2020-03-10 19:01
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(int id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            /**
             * 一秒以内走像正常的业务逻辑，超过一秒出错，出错要有个兜底的方法
            */
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")}
    )
    public String paymentInfo_Timeout(int id) {
        int timeout = 2;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout,id:" + id + ", 耗时" + timeout;
    }

    public String paymentInfo_TimeoutHandler(int id) {
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙或运行报错请稍候再试,id:" + id + ", O(∩_∩)O哈哈~";
    }
}
