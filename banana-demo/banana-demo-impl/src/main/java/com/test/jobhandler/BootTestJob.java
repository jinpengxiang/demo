package com.test.jobhandler;


import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * */
@JobHandler(value="bootTest2JobHandler33")
@Component
@Slf4j
public class BootTestJob extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        XxlJobLogger.log("UI日志显示");
        log.info("==========================param:" + param);
        return SUCCESS;
    }
}
