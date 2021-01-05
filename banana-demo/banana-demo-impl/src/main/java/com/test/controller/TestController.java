package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.test.config.MyStatusCode;
import com.test.service.ITest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "test")
@RestController
@Slf4j
public class TestController {
    @Autowired
    private ITest test;
    @ApiOperation(value = "test")
    public BaseResponseBody<String> test() {
        //TODO 传递header;Accept-Language=en/zh
        log.info("===============test==");
        return BaseResponseBody.from(MyStatusCode.test);
    }
}