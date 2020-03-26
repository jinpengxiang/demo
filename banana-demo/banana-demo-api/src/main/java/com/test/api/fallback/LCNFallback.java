package com.test.api.fallback;


import com.banana.starter.entity.BaseResponseBody;
import com.test.api.ILCNAPI;
import com.test.config.MyStatusCode;
import com.test.entity.bo.AuthorityParamTest;
import com.test.entity.bo.ModelParam;
import org.springframework.stereotype.Component;

@Component
public class LCNFallback implements ILCNAPI {
    @Override
    public BaseResponseBody<ModelParam> lcnPost(AuthorityParamTest form) {
        return BaseResponseBody.from(MyStatusCode.FEIGN_FAILED);
    }
}
