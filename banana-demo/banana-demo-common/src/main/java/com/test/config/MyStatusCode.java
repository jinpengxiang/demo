package com.test.config;


import com.banana.starter.entity.IStatusCode;

public enum MyStatusCode implements IStatusCode {
    //成功
    SUCCESS("0000"),
    //错误
    ERROR("9999"),
    test("5001"),
    token("401"),//TODO TOKEN错误
    UNAUTHORIZED("403"),
    FEIGN_FAILED("9998")
    ;
    private String code;

    MyStatusCode(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }
}
