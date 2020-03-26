package com.test.controller;



import com.banana.starter.auth.config.RedisClientDetailsService;
import com.banana.starter.auth.dto.OAuth2AccessTokenDTO;
import com.banana.starter.auth.service.IAuthService;
import com.banana.starter.auth.vo.TokenValidityVO;
import com.banana.starter.entity.BaseResponseBody;
import com.banana.starter.entity.CommonConstant;
import com.test.config.MyStatusCode;
import com.test.entity.bo.BeanTestBizUser;
import com.test.entity.bo.SoleTokenKeyDetailVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "token")
@RestController
@Slf4j
public class AuthController {
    @Resource
    private IAuthService authService;
    @Resource
    private RedisClientDetailsService redisClientDetailsService;

    @ApiOperation(value = "验证 + 自动刷新token + 自动刷新refreshToken")
    @GetMapping("/validityTokenOrRefreshToken")
    public BaseResponseBody<OAuth2AccessTokenDTO> validityTokenOrRefreshToken(
            @RequestHeader(name = CommonConstant.ACCESS_TOKEN) String accessToken) {
        BeanTestBizUser vo = authService.findRedisByAccessToken(accessToken, BeanTestBizUser.class);
        if(null == vo){
            //TODO TOKEN错误
            return BaseResponseBody.from(MyStatusCode.token);
        }
        SoleTokenKeyDetailVO soleTokenKeyDetailVO = new SoleTokenKeyDetailVO();
        soleTokenKeyDetailVO.setUsername(vo.getUserName());
        soleTokenKeyDetailVO.setUserA(vo.getPassword());
        return BaseResponseBody.success(MyStatusCode.SUCCESS, authService.validityTokenOrRefreshToken(accessToken, soleTokenKeyDetailVO));
    }

    @ApiOperation(value = "创建获取Token")
    @PostMapping("/createToken")
    public BaseResponseBody<OAuth2AccessTokenDTO> createToken(@RequestBody BeanTestBizUser vo) {
        SoleTokenKeyDetailVO soleTokenKeyDetailVO = new SoleTokenKeyDetailVO();
        soleTokenKeyDetailVO.setUsername(vo.getUserName());
        soleTokenKeyDetailVO.setUserA(vo.getPassword());
//        String secret = RedisClientDetailsService.getRandomString(20);
//        log.info(secret);
//        BaseClientDetails baseClientDetails = redisClientDetailsService.addClientDetails("banana", secret);
        return BaseResponseBody.success(MyStatusCode.SUCCESS, authService.createToken(soleTokenKeyDetailVO, vo));
    }

    @ApiOperation(value = "获取Token（有效期等）")
    @GetMapping("/getToken")
    public BaseResponseBody<OAuth2AccessTokenDTO> getToken(
            @RequestHeader(name = CommonConstant.ACCESS_TOKEN) String accessToken) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS, authService.getToken(accessToken));
    }

    @ApiOperation(value = "刷新Token")
    @GetMapping("/authRefreshToken/{refreshToken}")
    public BaseResponseBody<OAuth2AccessTokenDTO> authRefreshToken(
            @RequestHeader(name = CommonConstant.ACCESS_TOKEN) String accessToken,
            @PathVariable String refreshToken) {

        BeanTestBizUser vo = authService.findRedisByAccessToken(accessToken, BeanTestBizUser.class);
        if(null == vo){
            //TODO TOKEN错误
            return BaseResponseBody.from(MyStatusCode.token);
        }
        SoleTokenKeyDetailVO soleTokenKeyDetailVO = new SoleTokenKeyDetailVO();
        soleTokenKeyDetailVO.setUsername(vo.getUserName());
        soleTokenKeyDetailVO.setUserA(vo.getPassword());
        return BaseResponseBody.success(MyStatusCode.SUCCESS, authService.refreshToken(refreshToken, accessToken, soleTokenKeyDetailVO));
    }

    @ApiOperation(value = "删除/注销Token")
    @DeleteMapping("/removeToken")
    public BaseResponseBody removeToken(
            @RequestHeader(name = CommonConstant.ACCESS_TOKEN) String accessToken) {
        if (authService.removeToken(accessToken)){
            return BaseResponseBody.success(MyStatusCode.SUCCESS, null);
        }
        return BaseResponseBody.from(MyStatusCode.ERROR);
    }

    @ApiOperation(value = "获取用户对象信息")
    @GetMapping(value = "/findRedisByAccessToken")
    public BaseResponseBody<Object> findRedisByAccessToken(
            @RequestHeader(name = CommonConstant.ACCESS_TOKEN) String accessToken) {

        BeanTestBizUser vo = authService.findRedisByAccessToken(accessToken, BeanTestBizUser.class);
        return BaseResponseBody.success(MyStatusCode.SUCCESS, vo);
    }

    @ApiOperation(value = "获取AccessToRefresh", hidden = true)
    @GetMapping("/readAccessToRefresh")
    public BaseResponseBody<byte[]> readAccessToRefresh(
            @RequestHeader(name = CommonConstant.ACCESS_TOKEN) String accessToken) {
        return BaseResponseBody.success(MyStatusCode.SUCCESS, authService.readAccessToRefresh(accessToken));
    }

    @ApiOperation(value = "编辑TOKEN,RESFRESH-TOKEN有效期时间;单位:秒")
    @PostMapping("/refreshTokenValidity")
    public BaseResponseBody refreshTokenValidity(@RequestBody TokenValidityVO vo) {
        authService.refreshTokenValidity(vo);
        return BaseResponseBody.success(MyStatusCode.SUCCESS, null);
    }
}
