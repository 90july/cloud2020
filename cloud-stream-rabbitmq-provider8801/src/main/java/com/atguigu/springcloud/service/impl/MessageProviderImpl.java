package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author ariel
 * @create 2020-03-15 14:56
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output;
    @Override
    public String send() {
        String simpleUUID = IdUtil.simpleUUID();
        Message<String> stringMessage = MessageBuilder.withPayload(simpleUUID).build();
        output.send(stringMessage);
        log.info("simpleUUID = [" + simpleUUID + "]");
        return null;
    }
}
