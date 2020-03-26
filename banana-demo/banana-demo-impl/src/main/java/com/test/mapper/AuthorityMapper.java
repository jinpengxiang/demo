package com.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.entity.bo.PageParam;
import com.test.entity.dto.AuthorityBeanDTO;
import com.test.entity.po.AuthorityTest;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 金鹏祥
 * @since 2019-06-03
 */
public interface AuthorityMapper extends BaseMapper<AuthorityTest> {

    IPage<AuthorityBeanDTO> selectListPage(IPage page , @Param("param") PageParam param);
}
