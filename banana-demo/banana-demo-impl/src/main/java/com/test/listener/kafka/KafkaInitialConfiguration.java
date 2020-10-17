//package com.test.listener.kafka;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@Configuration
//public class KafkaInitialConfiguration {
//    @Autowired
//    private ConsumerFactory consumerFactory;
//    @Autowired
//    private KafkaListenerEndpointRegistry registry;
//
////    // 创建一个名为testtopic的Topic并设置分区数为8，分区副本数为2
////    @Bean
////    public NewTopic initialTopic() {
////        return new NewTopic("testtopic",8, (short) 2 );
////    }
////​
////    // 如果要修改分区数，只需修改配置值重启项目即可
////    // 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
////    @Bean
////    public NewTopic updateTopic() {
////        return new NewTopic("testtopic",10, (short) 2 );
////    }
//
//    @Bean
//    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
//        return (message, exception, consumer) -> {
//            System.out.println("消费异常："+message.getPayload());
//            return null;
//        };
//    }
//
//
//    // 消息过滤器
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
//        factory.setConsumerFactory(consumerFactory);
//        // 被过滤的消息将被丢弃
//        factory.setAckDiscarded(true);
//        // 消息过滤策略
//        factory.setRecordFilterStrategy(consumerRecord -> {
//            if (1 == consumerRecord.partition()) {
//                return false;
//            }
//            //返回true消息则被过滤
//            return true;
//        });
//        return factory;
//    }
//
//    // 监听器容器工厂(设置禁止KafkaListener自启动)
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory delayContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
//        container.setConsumerFactory(consumerFactory);
//        //禁止KafkaListener自启动
//        container.setAutoStartup(false);
//        return container;
//    }
//
////    // 定时启动监听器
////    @Scheduled(cron = "0 39 14 * * ? ")
////    public void startListener() {
////        System.out.println("启动监听器...");
////        // "timingConsumer"是@KafkaListener注解后面设置的监听器ID,标识这个监听器
////        if (!registry.getListenerContainer("timingConsumer").isRunning()) {
////            registry.getListenerContainer("timingConsumer").start();
////        }
////        //registry.getListenerContainer("timingConsumer").resume();
////    }
////
////    // 定时停止监听器
////    @Scheduled(cron = "0 45 14 * * ? ")
////    public void shutDownListener() {
////        System.out.println("关闭监听器...");
////        registry.getListenerContainer("timingConsumer").pause();
////    }
//}
