package com.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.test.entity.bo.AuthorityPageParamTest;
import com.test.entity.bo.AuthorityParamTest;
import com.test.entity.bo.PageParam;
import com.test.entity.dto.AuthorityBeanDTO;
import com.test.entity.po.AuthorityTest;

public interface ITest {
    String test();
    AuthorityTest createAuthority(AuthorityParamTest param);
    AuthorityTest findAuthorityByGroupId(Long groupId);
    IPage<AuthorityTest> findAuthorityPage(AuthorityPageParamTest param);
    IPage<AuthorityBeanDTO> findAuthorityBeanListPage(PageParam param);
//    void codePhone(String phone);
    void mq();
}