package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.test.config.Constant;
import com.test.config.MyStatusCode;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "路由message")
@RestController
@Slf4j
public class GatewayMessageController {
    @GetMapping(value = "/skip/{code}")
    public BaseResponseBody skip(@PathVariable String code){
        if(Constant.UNAUTHORIZED_CODE.equalsIgnoreCase(code)){
            return BaseResponseBody.error(MyStatusCode.UNAUTHORIZED);
        }
        return null;
    }
}