package com.example.rocketmqproducer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: ma_qiankun
 * @date: 2022/7/16
 **/
@Component
@DependsOn(value = "defaultMQProducer")
public class CommandLineRunnerSend  implements CommandLineRunner {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void run(String... args) throws Exception {
        while (true){
            DefaultMQProducer defaultMQProducer1 = new DefaultMQProducer();
            defaultMQProducer1.setProducerGroup("hello");
            rocketMQTemplate.convertAndSend("test-topic-1", "Hello, World!");
            rocketMQTemplate.send("test-topic-1", MessageBuilder.withPayload("Hello, World! I'm from spring message").build());
            DefaultMQProducer defaultMQProducer = rocketMQTemplate.getProducer();
            Message message = new Message("test-topic-2", "springboot 整合 rocketmq 发送的消息".getBytes());
            defaultMQProducer.send(message);
            Thread.sleep(1000);
        }

    }



}
