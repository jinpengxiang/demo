package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.test.config.MyStatusCode;
import com.test.service.ITest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "国际化;标签输出;测试")
@RestController
@Slf4j
public class I18nController {
    @Autowired
    private ITest test;
    @ApiOperation(value = "自定义标签输出")
    @GetMapping("/i18n/{id}/{str}")
    public BaseResponseBody<String> i18ncu(@PathVariable float id, @PathVariable String str) {
        //TODO 传递header;Accept-Language=en/zh
        log.info("i18n=================================");
        return BaseResponseBody.from(MyStatusCode.test);
    }
}