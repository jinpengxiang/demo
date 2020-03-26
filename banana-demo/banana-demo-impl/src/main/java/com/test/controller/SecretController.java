package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.banana.starter.secret.annotation.GetDeCode;
import com.banana.starter.secret.annotation.PostDeCode;
import com.banana.starter.secret.annotation.ReturnEnCode;
import com.test.config.MyStatusCode;
import com.test.entity.bo.ModelParam;
import com.test.service.ITest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "加密测试")
@RestController
@Slf4j
public class SecretController {
    @Autowired
    private ITest test;

    @ApiOperation(value = "测试float")
    @GetDeCode(inDecode = true)//TODO GET解密
    @ReturnEnCode(outEncode = true)//TODO 返回加密
    @GetMapping("/getPathVariable/{id}/{str}")
    public BaseResponseBody<String> getPathVariable(@PathVariable float id, @PathVariable String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS, "aaaaaaa");
    }

    @ApiOperation(value = "测试short")
    @GetDeCode//(inDecode = false)//TODO GET解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @GetMapping("/getPathVariable2/{id}/{str}")
    public BaseResponseBody<String> getPathVariable2(@PathVariable short id, @PathVariable String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,"hello" + id + str);
    }

    //TODO 想测试按以上@ApiOperation(value = "测试xx")
    @GetDeCode//(inDecode = false)//TODO GET解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @GetMapping("/getPathVariable3/{id}/{str}")
    public BaseResponseBody<String> getPathVariable3(@PathVariable double id, @PathVariable String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,"hello" + id + str);
    }

    @GetDeCode//(inDecode = false)//TODO GET解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @GetMapping("/getPathVariable4/{id}/{str}")
    public BaseResponseBody<String> getPathVariable4(@PathVariable int id, @PathVariable String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,"hello" + id + str);
    }

    @GetDeCode//(inDecode = false)//TODO GET解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @GetMapping("/getPathVariable5/{id}/{str}")
    public BaseResponseBody<String> getPathVariable5(@PathVariable boolean id, @PathVariable String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,"hello" + id + str);
    }

    @GetDeCode//(inDecode = false)//TODO GET解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @GetMapping("/getPathVariable6/{id}/{str}")
    public BaseResponseBody<String> getPathVariable6(@PathVariable long id, @PathVariable String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,"hello" + id + str);
    }

    @GetDeCode//(inDecode = false)//TODO GET解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @GetMapping("/getRequestParam")
    public BaseResponseBody<String> getRequestParam(@RequestParam int id, @RequestParam String str) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,"hello" + id + str);
    }

    @ApiOperation(value = "POST")
    @PostDeCode//(inDecode = false)//TODO POST解密
    @ReturnEnCode//(outEncode = false)//TODO 返回加密
    @PostMapping("/post")
    public BaseResponseBody<ModelParam> post(@RequestBody ModelParam form) {
        return BaseResponseBody.from(MyStatusCode.test);
    }
}