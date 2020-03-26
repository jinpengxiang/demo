package com.test.entity.dto;

import com.test.entity.po.AuthorityTest;
import lombok.Data;

@Data
public class AuthorityBeanDTO {
    private String groupName;
    private AuthorityTest authorityTest;
}
