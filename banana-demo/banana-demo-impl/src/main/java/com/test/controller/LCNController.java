package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.test.config.MyStatusCode;
import com.test.entity.bo.AuthorityParamTest;
import com.test.entity.bo.ModelParam;
import com.test.service.ITest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "LCN分布式事务")
@RestController
@Slf4j
public class LCNController {
    @Autowired
    private ITest test;

    @ApiOperation(value = "POST-LCN分布式事务测试")
    @PostMapping("/lcnPost")
    public BaseResponseBody<ModelParam> lcnPost(@RequestBody AuthorityParamTest form) {
        test.createAuthority(form);
        return BaseResponseBody.from(MyStatusCode.test);
    }
}
