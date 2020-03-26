package com.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.banana.starter.entity.BaseResponseBody;
import com.test.config.MyStatusCode;
import com.test.entity.bo.AuthorityPageParamTest;
import com.test.entity.bo.PageParam;
import com.test.entity.dto.AuthorityBeanDTO;
import com.test.entity.po.AuthorityTest;
import com.test.service.ITest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "分页")
@RestController
@Slf4j
public class PageController {
    @Autowired
    private ITest test;

    @ApiOperation(value = "分页")
    @PostMapping("/page")
    public BaseResponseBody<IPage<AuthorityTest>> page(@RequestBody AuthorityPageParamTest param) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,test.findAuthorityPage(param));
    }

    @ApiOperation(value = "关联sql分页")
    @PostMapping("/pageSQL")
    public BaseResponseBody<IPage<AuthorityBeanDTO>> pageSQL(@RequestBody PageParam param) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS,test.findAuthorityBeanListPage(param));
    }
}