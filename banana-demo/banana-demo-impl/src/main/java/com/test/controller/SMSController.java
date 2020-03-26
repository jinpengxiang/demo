//package com.test.controller;
//
//import com.banana.oss.config.OSSFactory;
//import com.banana.starter.entity.BaseResponseBody;
//import com.test.config.MyStatusCode;
//import com.test.entity.po.SMSPhoneVO;
//import com.test.service.ITest;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@Api(tags = "sms")
//@RestController
//@Slf4j
//public class SMSController {
//    @Autowired
//    private ITest test;
//
//    @ApiOperation(value = "短信")
//    @PostMapping("/sms")
//    public BaseResponseBody<String> redis(@RequestBody SMSPhoneVO vo) {
//
//        //TODO 国内'+86'+手机号码
//        //TODO 国外例0086+半角空格+手机号码
//        test.codePhone(vo.getPhone());
//        return BaseResponseBody.from(MyStatusCode.SUCCESS, null);
//    }
//}