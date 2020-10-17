//package com.test.controller;
//
//import com.banana.starter.entity.BaseResponseBody;
//import com.test.config.MyStatusCode;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.support.SendResult;
//import org.springframework.util.concurrent.ListenableFutureCallback;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@RestController
//@Slf4j
//public class KafkaProducerController {
//    @Resource
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
//    // 发送消息
//    @GetMapping("/kafka/normal/{message}")
//    public void sendMessage1(@PathVariable("message") String normalMessage) {
//        kafkaTemplate.send("topic1", normalMessage);
//
////        int i = 0;
////        while (true) {
////            if(i == 50){
////                break;
////            }
////            try {
////                Thread.sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            normalMessage = "test-simple-producer : " + i ++;
////            kafkaTemplate.send("topic1", normalMessage);
////        }
//
//    }
//
//    /****
//     * @Description 回调的生产者 写法1
//     * @Param [callbackMessage]
//     * @Author jpx
//     * @Version  1.0
//     * @Return void
//     * @Exception
//     * @Date 2020/9/24
//     */
//    @GetMapping("/kafka/callbackOne/{message}")
//    public void sendMessage2(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("topic1", callbackMessage).addCallback(success -> {
//            // 消息发送到的topic
//            String topic = success.getRecordMetadata().topic();
//            // 消息发送到的分区
//            int partition = success.getRecordMetadata().partition();
//            // 消息在分区内的offset
//            long offset = success.getRecordMetadata().offset();
//            System.out.println("发送消息成功:" + topic + "-" + partition + "-" + offset);
//        }, failure -> {
//            System.out.println("发送消息失败:" + failure.getMessage());
//        });
//    }
//
//    /****
//     * @Description 回调的生产者 写法2
//     * @Param [callbackMessage]
//     * @Author jpx
//     * @Version  1.0
//     * @Return void
//     * @Exception
//     * @Date 2020/9/24
//     */
//    @GetMapping("/kafka/callbackTwo/{message}")
//    public void sendMessage3(@PathVariable("message") String callbackMessage) {
//        kafkaTemplate.send("topic1", callbackMessage).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//            @Override
//            public void onFailure(Throwable ex) {
//                System.out.println("发送消息失败："+ex.getMessage());
//            }
//
//            @Override
//            public void onSuccess(SendResult<String, Object> result) {
//                System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
//                        + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
//            }
//        });
//    }
//
//    /****
//     * @Description kafka事务
//     * @Param []
//     * @Author jpx
//     * @Version  1.0
//     * @Return void
//     * @Exception
//     * @Date 2020/9/24
//     */
//    @GetMapping("/kafka/transaction")
//    public BaseResponseBody<String> sendMessage7(){
//        kafkaTemplate.executeInTransaction(operations -> {
//                operations.send("topic1","test executeInTransaction").addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//                    @Override
//                    public void onFailure(Throwable ex) {
//                        System.out.println("发送消息失败："+ex.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(SendResult<String, Object> result) {
//                        System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
//                                + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
//                    }
//                });
////            int i=1/0; //TODO 代码异常测试事务
////            int count = 1;
////            if(1 == count){
////                log.info("================人为测试异常============");
////                throw new BusinessException(MyStatusCode.ERROR);//TODO 人为测试异常
////            }
//            return true;
//        });
//
//        return BaseResponseBody.from(MyStatusCode.SUCCESS);
//    }
//
//    /****
//     * @Description kafka事务
//     * @Param []
//     * @Author jpx
//     * @Version  1.0
//     * @Return void
//     * @Exception
//     * @Date 2020/9/24
//     */
//    @GetMapping("/kafka/sendMessageBatch")
//    public BaseResponseBody<String> sendMessageBatch(){
//        kafkaTemplate.executeInTransaction(operations -> {
//            for(int i = 0; i < 100; i++){
//                operations.send("topic1","test executeInTransaction").addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
//                    @Override
//                    public void onFailure(Throwable ex) {
//                        System.out.println("发送消息失败："+ex.getMessage());
//                    }
//
//                    @Override
//                    public void onSuccess(SendResult<String, Object> result) {
//                        System.out.println("发送消息成功：" + result.getRecordMetadata().topic() + "-"
//                                + result.getRecordMetadata().partition() + "-" + result.getRecordMetadata().offset());
//                    }
//                });
//            }
////            int i=1/0; //TODO 代码异常测试事务
////            int count = 1;
////            if(1 == count){
////                log.info("================人为测试异常============");
////                throw new BusinessException(MyStatusCode.ERROR);//TODO 人为测试异常
////            }
//            return true;
//        });
//
//        return BaseResponseBody.from(MyStatusCode.SUCCESS);
//    }
//}
