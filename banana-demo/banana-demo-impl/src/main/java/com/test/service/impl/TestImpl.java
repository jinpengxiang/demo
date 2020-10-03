package com.test.service.impl;

import com.banana.mybatis.config.common.ParamCommonUtils;
//import com.banana.redis.config.IRedisTool;
import com.banana.starter.exception.BusinessException;
//import com.banana.starter.mq.service.IMQTool;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
//import com.kitedge.middle.user.api.IAuthorityGroupAPI;
//import com.kitedge.middle.user.entity.bo.authority.AuthorityGroupParam;
import com.test.config.MyStatusCode;
import com.test.config.Properties;
import com.test.entity.bo.AuthorityPageParamTest;
import com.test.entity.bo.AuthorityParamTest;
import com.test.entity.bo.PageParam;
import com.test.entity.dto.AuthorityBeanDTO;
import com.test.mapper.AuthorityMapper;
import com.test.entity.po.AuthorityTest;
import com.test.service.ITest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;

@Service
@Slf4j
public class TestImpl implements ITest {
    @Resource
    private AuthorityMapper authorityMapper;

    @Resource
    private RestTemplate restTemplate;

//    @Resource
//    private IAuthorityGroupAPI authorityGroupAPI;
//    @Resource
//    private IRedisTool redisTool;
//    @Resource
//    private IMQTool mqTool;
//    @Resource
//    private IRongLianSMS rongLianSMS;
//    @Resource
//    private IZhuTongSMS zhuTongSMS;

    @Override
    public IPage<AuthorityTest> findAuthorityPage(AuthorityPageParamTest param) {
        LambdaQueryWrapper<AuthorityTest> lambdaQueryWrapper = Wrappers.lambdaQuery();
        if(StringUtils.isNotBlank(param.getName())){
            lambdaQueryWrapper.like(AuthorityTest::getName, param.getName());
        }if(null != param.getChannelId()){
            lambdaQueryWrapper.eq(AuthorityTest::getChannelId, param.getChannelId());
        }
        return authorityMapper.selectPage(
                ParamCommonUtils.getMPPage(param.getBaseListParam()), lambdaQueryWrapper);
    }

    @Override
    public IPage<AuthorityBeanDTO> findAuthorityBeanListPage(PageParam param) {
        AuthorityTest authorityTest = new AuthorityTest();
        param.setAuthorityId(1l);
        return authorityMapper.selectListPage(ParamCommonUtils.getMPPage(param.getBaseListParam()), param);
    }

//    @Override
//    public void codePhone(String phone) {
//        //生成验证码
//        Random random = new Random();
//        String code="";
//        for (int i=0;i<6;i++)
//        {
//            code += random.nextInt(10);
//        }
//        //推送短信
//        String codeId = "78584"; //模板编号
//        //【办伴招运】您的验证码是{1}，在5分钟内有效，如非本人操作请忽略本短信。
//        String[] params = new String[]{code,"5"};
//        //判断号码是否为国际号段
//        String num = phone.substring(0,3);
//        if (num.equals("+86")) {//如果+86则走融联云接口发送短信
//            rongLianSMS.sendEms(phone, codeId, params);
//        }else {
//            String countryNum = org.apache.commons.lang.StringUtils.substringBefore(phone," ");
//            int a = countryNum.length()+1;
//            countryNum = countryNum.substring(countryNum.indexOf('+')+1, countryNum.length());
//            countryNum=("0000"+countryNum);
//            countryNum=countryNum.substring(countryNum.length()-4);
//            phone = countryNum + phone.substring(a);//国际号码，在号码前加国家编号
//            String m = "【Distrii】Dear user, your dynamic verification code is {0}. The verification code is valid for {1} minutes.";//短信模板
//            zhuTongSMS.sendEmsMessage(phone,m,params);
//        }
//    }

    //    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
//        @Override
//        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//            log.info("===correlationData_id: " + correlationData.getId() + "===ack:" + ack);
//            if(!ack){
//                log.error("消息异常.");
//            }
//        }
//    };
//
//    final RabbitTemplate.ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {
//        @Override
//        public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
//            log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",
//                    exchange, routingKey, replyCode,replyText, message);
//        }
//    };

    @Override
    public void mq() {
//        mqTool.sendRabbitMsg("abc");
//        mqTool.sendRabbitMsg("abc", this.confirmCallback, this.returnCallback);
    }

    @Override
    public AuthorityTest findAuthorityByGroupId(Long id) throws BusinessException {
//        //TODO （KeySerializer-key为字符串类型;value：支持序列化；反序列化八种基础类型）
//        redisTemplate.opsForHash().put("test", "11223345", 22l);
//        //TODO 测试redis
//        Object obj = redisTemplate.opsForHash().get(Constant.ACCESS_TOKEN_KEY, "1122");
//        AuthorityTest authority = authorityMapper.selectById(id);
//        return authority;

//        AuthorityBeanDTO authorityBeanVO = new AuthorityBeanDTO();
//        AuthorityTest authorityTest = new AuthorityTest();
//        authorityTest.setName("name1");
//        authorityBeanVO.setAuthorityTest(authorityTest);
//        authorityBeanVO.setGroupName("test1");
//
//        redisTool.set("test_en", authorityBeanVO);
//        Collection  collection = new ArrayList<>();
//        collection.add(authorityBeanVO);
//        authorityBeanVO = new AuthorityBeanDTO();
//        authorityTest = new AuthorityTest();
//        authorityTest.setName("name2");
//        authorityBeanVO.setAuthorityTest(authorityTest);
//        authorityBeanVO.setGroupName("test2");
//        collection.add(authorityBeanVO);
//        try {
//            redisTool.listSet("test_list_en", collection);
//
//            collection = new ArrayList<>();
//            ((ArrayList) collection).add("1");
//            redisTool.listSet("test_list_en_str", collection);
//
//            collection = new ArrayList<>();
//            ((ArrayList) collection).add(1);
//            redisTool.listSet("test_list_en_int", collection);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        redisTool.hset("test_has", "has_en", authorityBeanVO);
//
//        try {
//            log.info(redisTool.get("test_en", AuthorityBeanDTO.class).getAuthorityTest().getName());
//            log.info(redisTool.hget("test_has", "has_en", AuthorityBeanDTO.class).getAuthorityTest().getName());
//
//            ArrayList<AuthorityBeanDTO> list = (ArrayList<AuthorityBeanDTO>) redisTool.listGet("test_list_en", AuthorityBeanDTO.class);
//            for(AuthorityBeanDTO s : list){
//                log.info(s.getAuthorityTest().getName());
//            }
//
//            ArrayList<String> list2 = (ArrayList<String>) redisTool.listGet("test_list_en_str", String.class);
//            for(String s : list2){
//                log.info(s);
//            }
//
//            ArrayList<Integer> list3 = (ArrayList<Integer>) redisTool.listGet("test_list_en_int", Integer.class);
//            for(Integer s : list3){
//                log.info(s + "");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        redisTemplate.opsForHash().put("test111", "abc", authorityBeanVO);
//        log.info(((AuthorityBeanDTO)redisTemplate.opsForHash().get("test111", "abc")).getAuthorityTest().getName());

        return null;
    }

    @Override
//    @Transactional
//    @LcnTransaction
    public AuthorityTest createAuthority(AuthorityParamTest param) throws BusinessException {
//        AuthorityGroupParam authorityGroupParam = new AuthorityGroupParam();
//        authorityGroupParam.setName("user");
//        authorityGroupParam.setChannelId(1l);
//        authorityGroupAPI.createAuthorityGroup(authorityGroupParam);
////

//        restTemplate.patchForObject("lcnPost")

        AuthorityTest authority = new AuthorityTest();
        BeanUtils.copyProperties(param, authority);
//        authority.setStatus(1l);
        authority.setName("banana-demo-a");
        int count = authorityMapper.insert(authority);
//        if(count == 1){
//            throw new BusinessException(MyStatusCode.ERROR);
//        }
        return authority;
    }


    @Override
    public String test() {
        return "";
    }

    @Override
    public String refreshScopeStr(Properties properties) {
        return properties.getUserName();
    }
}
