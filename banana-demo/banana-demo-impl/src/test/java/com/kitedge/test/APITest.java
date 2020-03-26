//package com.kitedge.test;
//
//import com.alibaba.fastjson.JSONObject;
//import com.kitedge.common.mybatis.common.BaseListParam;
//import com.test.AppTestAction;
//import com.kitedge.job.entity.bo.XxlJobInfoPageParam;
//import com.kitedge.middle.job.api.IActuatorAPI;
//import com.kitedge.middle.job.api.IJobAPI;
//import com.kitedge.middle.message.api.MessageApi;
//import com.kitedge.middle.user.api.ChannelApi;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppTestAction.class)
//public class APITest {
////    @Resource
////    private IAuthorityAPI authorityAPI;
//    @Resource
//    private ChannelApi channelApi;
//    @Resource
//    private MessageApi messageApi;
//    @Resource
//    private IJobAPI jobAPI;
//    @Resource
//    private IActuatorAPI actuatorAPI;
//
////    @Autowired
////    private AdminService helloService;
//
//    @Test
//    public void testApi(){
////        AuthorityParamTest authorityParam = new AuthorityParamTest();
////        authorityParam.setValue("abc");
////        authorityParam.setName("abc");
////        authorityParam.setChannelId(11l);
////        System.out.println("=============================" + authorityAPI.createAuthority(authorityParam).getStatus());
////
//        System.out.println("=============================" + JSONObject.toJSON(channelApi.channelDetail(1l).getData()));
//
//
////        RabbitParam rabbitParam = new RabbitParam();
////        rabbitParam.setMsg("aaaaaaaaaa");
////        System.out.println("=============================" + messageApi.sendRabbitMsg(rabbitParam).getStatus());
//
//
//        System.out.println("=============================" + actuatorAPI.loadById(9).getStatus());
//
//        XxlJobInfoPageParam xxlJobInfoPageParam = new XxlJobInfoPageParam();
//        BaseListParam baseListParam = new BaseListParam();
//        baseListParam.setPage(1);
//        baseListParam.setPageSize(10);
//        xxlJobInfoPageParam.setBaseListParam(baseListParam);
//        System.out.println("=============================" + jobAPI.pageList(xxlJobInfoPageParam).getStatus());
//
//    }
//
//
////    @Test
////    public void findAuthorityById(){
//
////        System.out.println("=============================" + channelApi.channelDetail(1l).getStatus());
////        System.out.println(helloService.haloHello() + "=======================");
////    }
//}
