//package com.test.listener;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.rabbit.support.CorrelationData;
//import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class TestListener {
//    @RabbitListener(queues = "banan_demo.test1")
//    public void handleMessage(String text) {
//        System.out.println("Received--------------------------: " + text);
//    }
//}
