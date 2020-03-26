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
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "REDIS测试")
@RestController
@Slf4j
public class RedisController {
    @Autowired
    private ITest test;

    @ApiOperation(value = "REDIS测试")
    @GetMapping("/redis/{id}")
    public BaseResponseBody<String> redis(@PathVariable long id) {
        //TODO 传递header;Accept-Language=en/zh
        test.findAuthorityByGroupId(1l);
        return BaseResponseBody.from(MyStatusCode.test);
    }
}