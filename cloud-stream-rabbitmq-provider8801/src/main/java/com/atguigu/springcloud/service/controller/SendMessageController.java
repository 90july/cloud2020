package com.atguigu.springcloud.service.controller;

import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ariel
 * @create 2020-03-15 15:03
 */
@RestController
@Slf4j
public class SendMessageController {
    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public void sendMessage(){
        messageProvider.send();
    }
}
