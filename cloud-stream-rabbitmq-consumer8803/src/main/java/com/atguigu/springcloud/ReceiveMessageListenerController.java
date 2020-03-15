package com.atguigu.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ariel
 * @create 2020-03-15 18:28
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("message = [" + message + "],serverPort = ["+serverPort+"]");
    }

    @Value("${server.port}")
    private String serverPort;
}
