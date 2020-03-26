package com.banana.gateway.common;

public class Constant {
	private static final String SKIP_FEIGN_FAILED = "/" + ServiceNameConst.BANANA_DEMO + "/skip/"; //TODO 自定义网关跳转
	public static final String UNAUTHORIZED_CODE = "403";
	public static final String UNAUTHORIZED_CODE_URL = Constant.SKIP_FEIGN_FAILED + Constant.UNAUTHORIZED_CODE; //TODO TOKEN错误码
}
