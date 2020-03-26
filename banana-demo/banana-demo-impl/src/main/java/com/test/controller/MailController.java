package com.test.controller;

import com.banana.starter.mail.service.IMailService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.banana.starter.entity.BaseResponseBody;
import com.test.config.MyStatusCode;
import com.test.entity.bo.AuthorityPageParamTest;
import com.test.entity.po.AuthorityTest;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "邮件")
@RestController
@Slf4j
public class MailController {
    @Resource
    private IMailService mailService;

    @ApiOperation(value = "html模板引擎邮件发送")
    @GetMapping("/mailT")
    public BaseResponseBody<IPage<AuthorityTest>> mailT() throws MessagingException, IOException, TemplateException {
        Map<String, Object> params = new HashMap<>();
        params.put("username", "test-name");
        String[] to = {"a@163.com","b@qq.com"};
        mailService.sendTemplateMail("bbbb",params, "/mail", "mail.ftl",to);
        return BaseResponseBody.success(MyStatusCode.SUCCESS, null);
    }

    @ApiOperation(value = "html邮件发送")
    @GetMapping("/mail")
    public BaseResponseBody<IPage<AuthorityTest>> mail() throws MessagingException {
        String[] to = {"a@163.com","b@qq.com"};
        mailService.sendMail("aaaa","测试邮件", to);
        return BaseResponseBody.success(MyStatusCode.SUCCESS, null);
    }
}