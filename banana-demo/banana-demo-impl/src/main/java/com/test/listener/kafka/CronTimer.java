//package com.test.listener.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@EnableScheduling
//@Component
//public class CronTimer {
//    /**
//     * @KafkaListener注解所标注的方法并不会在IOC容器中被注册为Bean，
//     * 而是会被注册在KafkaListenerEndpointRegistry中，
//     * 而KafkaListenerEndpointRegistry在SpringIOC中已经被注册为Bean
//     **/
//    @Autowired
//    private KafkaListenerEndpointRegistry registry;
//
//    // 定时启动监听器
//    @Scheduled(cron = "0 10 15 * * ? ")
//    public void startListener() {
//        System.out.println("启动监听器...");
//        // "timingConsumer"是@KafkaListener注解后面设置的监听器ID,标识这个监听器
//        if (!registry.getListenerContainer("timingConsumer").isRunning()) {
//            registry.getListenerContainer("timingConsumer").start();
//        }
//        //registry.getListenerContainer("timingConsumer").resume();
//    }
//
//    // 定时停止监听器
//    @Scheduled(cron = "0 15 15 * * ? ")
//    public void shutDownListener() {
//        System.out.println("关闭监听器...");
//        registry.getListenerContainer("timingConsumer").pause();
//    }
//}