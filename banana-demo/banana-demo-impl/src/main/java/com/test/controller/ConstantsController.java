package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.test.config.Properties;
import com.test.config.MyStatusCode;
import com.test.service.ITest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "refreshScope")
@RestController
@Slf4j
public class ConstantsController {
    @Autowired
    private ITest test;
    @Autowired
    private Properties properties;

    @ApiOperation(value = "")
    @GetMapping("/refreshScope")
    public BaseResponseBody<String> RefreshScope() {
        //TODO 传递header;Accept-Language=en/zh
        log.info("RefreshScope=====================" + test.refreshScopeStr(properties));
        return BaseResponseBody.from(MyStatusCode.test);
    }
}