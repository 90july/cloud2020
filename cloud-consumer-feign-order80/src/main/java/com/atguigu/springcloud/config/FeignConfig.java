package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ariel
 * @create 2020-03-09 20:04
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
}
