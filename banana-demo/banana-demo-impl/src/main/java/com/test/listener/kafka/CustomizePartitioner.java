//package com.test.listener.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.producer.Partitioner;
//import org.apache.kafka.common.Cluster;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
//
//import java.util.List;
//import java.util.Map;
//
///****
// * @Description 自定义分区策略
// * @Param
// * @Author jpx
// * @Version  1.0
// * @Return
// * @Exception
// * @Date 2020/9/24
// */
//public class CustomizePartitioner implements Partitioner {
//    @Override
//    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
//        // 自定义分区规则(这里假设全部发到0号分区)
//        // ......
//        return 0;
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//    @Override
//    public void configure(Map<String, ?> configs) {
//
//    }
//}
