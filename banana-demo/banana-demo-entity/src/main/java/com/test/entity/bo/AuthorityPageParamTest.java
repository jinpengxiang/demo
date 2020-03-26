package com.test.entity.bo;

import com.banana.mybatis.config.common.BaseListParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AuthorityPageParamTest {
    private BaseListParam baseListParam;
    @ApiModelProperty(value = "权限名称",required = false)
    private String name;
    @ApiModelProperty(value = "渠道ID",required = true)
    private Long channelId;
}
