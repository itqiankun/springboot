package com.example.rocketmqproducer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

@SpringBootApplication
public class RocketmqProducerApplication  {


    public static void main(String[] args) {
        SpringApplication.run(RocketmqProducerApplication.class, args);
    }

}
