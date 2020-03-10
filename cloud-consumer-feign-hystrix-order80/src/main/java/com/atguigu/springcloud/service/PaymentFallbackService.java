package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author ariel
 * @create 2020-03-11 0:03
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(int id) {
        return "paymentInfo_OK fallback O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_Timeout(int id) {
        return "paymentInfo_Timeout fallback O(∩_∩)O哈哈~";
    }
}
