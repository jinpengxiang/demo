package com.test.controller;

import com.banana.starter.entity.BaseResponseBody;
import com.banana.oss.config.OSSFactory;
import com.test.config.MyStatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "oss")
@RestController
@Slf4j
public class OSSController {
    @ApiOperation(value = "上传")
    @PostMapping("/oss/uploadFile")
    public BaseResponseBody<String> redis(@RequestParam("file") MultipartFile file) {
        String url = "";
        try {
            url = OSSFactory.build().uploadFileSuffix(file.getBytes(), "",
                    String.valueOf(System.currentTimeMillis())+"/" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BaseResponseBody.from(MyStatusCode.test, url);
    }
}