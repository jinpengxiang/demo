package com.test.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *  权限
 * </p>
 *
 * @author 金鹏祥
 * @since 2019-06-03
 */
@Data
public class AuthorityParamTest {
    @ApiModelProperty(value = "权限名称",required = true)
    private String name;
    @ApiModelProperty(value = "接口路径",required = true)
    private String value;
    @ApiModelProperty(value = "创建用户id")
    protected Long createUserId;
    @ApiModelProperty(value = "更新用户id")
    protected Long modifiedUserId;
    @ApiModelProperty(value = "渠道ID",required = true)
    private Long channelId;
}
