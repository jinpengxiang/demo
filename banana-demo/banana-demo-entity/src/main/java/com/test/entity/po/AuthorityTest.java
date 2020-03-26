package com.test.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *  权限
 * </p>
 *
 * @author 金鹏祥
 * @since 2019-06-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("authority")
public class AuthorityTest extends BasePO implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "authority_id", type = IdType.AUTO)
    private Long authorityId;
    private String name;
    private String value;
    private Long channelId;
}
