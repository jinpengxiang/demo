//package com.test.controller;
//
//import com.banana.starter.entity.BaseResponseBody;
//import com.banana.starter.mq.service.IMQTool;
//import com.test.config.MyStatusCode;
//import com.test.entity.bo.AuthorityParamTest;
//import com.test.entity.bo.ModelParam;
//import com.test.service.ITest;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
//@Api(tags = "MQ")
//@RestController
//@Slf4j
//public class MQController {
//    @Autowired
//    private ITest test;
//
//    @ApiOperation(value = "mq")
//    @PostMapping("/mq")
//    public BaseResponseBody<ModelParam> mq(@RequestBody AuthorityParamTest form) {
//        test.mq();
//        return BaseResponseBody.from(MyStatusCode.test);
//    }
//}