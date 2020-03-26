package com.test.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BasePO {
    //逻辑删除：0-删除，1-有效
    @TableLogic(value = "1", delval = "0")
    protected Byte status;

    //创建用户id
    protected Long createUserId;

    //创建时间
    protected Date gmtCreate;

    //更新用户id
    protected Long modifiedUserId;

    //更新时间，mybatis-plus框架自动更新
    @TableField(update = "now()")
    protected Date gmtModified;
}
