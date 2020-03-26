package com.test.api;

import com.banana.starter.entity.BaseResponseBody;
import com.test.api.fallback.LCNFallback;
import com.test.entity.bo.AuthorityParamTest;
import com.test.entity.bo.ModelParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "banana-demo", fallback = LCNFallback.class)
public interface ILCNAPI {
    @ApiOperation(value = "获取任务列表")
    @PostMapping("/lcnPost")
    BaseResponseBody<ModelParam> lcnPost(@RequestBody AuthorityParamTest form);
}

