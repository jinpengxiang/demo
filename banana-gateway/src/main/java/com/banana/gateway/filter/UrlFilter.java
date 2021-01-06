//package com.banana.gateway.filter;
//
//import com.banana.gateway.Properties;
//import com.banana.gateway.common.Constant;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.util.ObjectUtils;
//import org.springframework.util.PathMatcher;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Slf4j
//public class UrlFilter implements GlobalFilter, Ordered {
//    private PathMatcher matcher = new AntPathMatcher();
//    @Autowired
//    private Properties properties;
////    @Resource
////    private ITokenAPI tokenAPI;
////    @Resource
////    private UserApi userApi;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerHttpRequest request = exchange.getRequest();
//        log.info("============path" + "============" + request.getURI().getPath());
//
//        if (this.matches(request.getURI().getPath(), properties.getAuthUrls())) {
//            return this.fallBack(Constant.UNAUTHORIZED_CODE_URL, exchange);
//        }
//
////        //TODO 通配地址（网关过滤请求地址）
////        if (!this.matches(request.getURI().getPath(), properties.getNoAuthUrls())) {
////            return this.fallBack(Constant.UNAUTHORIZED_CODE_URL, exchange);
////            //TODO 用户中心auth域名地址才校验TOKEN
////            Object headerToken = request.getHeaders().get(Constant.ACCESS_TOKEN);
////            if (!ObjectUtils.isEmpty(headerToken)) {
////                String accessToken = ((List) headerToken).get(0).toString();
////                log.info("============HEADER_TOKEN=========" + accessToken);
////                //TODO 获取用户对象
////                BaseResponseBody<UserDetailDTO> userDetailDTO = userApi.findRedisByAccessToken(accessToken);
////                if(Constant.FEIGN_FAILED_CODE.equalsIgnoreCase(userDetailDTO.getStatus())){
////                    //TODO 熔断
////                    return this.fallBack(Constant.SKIP_FEIGN_FAILED, exchange);
////                }if(!ObjectUtils.isEmpty(userDetailDTO.getData())){
////                    BaseResponseBody<OAuth2AccessTokenDTO> oAuth2AccessTokenDTO = tokenAPI.getToken(accessToken);
////                    if(Constant.FEIGN_FAILED_CODE.equalsIgnoreCase(oAuth2AccessTokenDTO.getStatus())){
////                        //TODO 熔断
////                        return this.fallBack(Constant.SKIP_FEIGN_FAILED, exchange);
////                    }if(ObjectUtils.isEmpty(oAuth2AccessTokenDTO.getData())){
////                        //TODO 检查TOKEN是否过期
////                        BaseResponseBody<byte[]> bytes = tokenAPI.readAccessToRefresh(accessToken);
////                        if(!ObjectUtils.isEmpty(bytes.getData())){
////                            //TODO TOKEN过期
////                            return this.fallBack(Constant.SKIP_TOKEN_FAILURE, exchange);
////                        }else{
////                            //TODO REFRESH-TOKEN过期；重新登陆
////                            return this.fallBack(Constant.SKIP_REFRESH_TOKEN_FAILURE, exchange);
////                        }
////                    }
////                    //TODO 用户角色/接口权限-待研发
////                    if (!ObjectUtils.isEmpty(userDetailDTO.getData().getAuthorities())) {
////                        if(0 == userDetailDTO.getData().getAuthorities().size()){
////                            return this.fallBack(Constant.SKIP_FORBIDDEN, exchange);
////                        }if (!this.matchesDTO(request.getURI().getPath(), userDetailDTO.getData().getAuthorities())) {
////                            return this.fallBack(Constant.SKIP_FORBIDDEN, exchange);
////                        }
////                    }
////                }
////                //TODO TOKEN错误
////                return this.fallBack(Constant.SKIP_UNAUTHORIZED, exchange);
////            }else{
////                log.info("============HEADER_TOKEN IS NULL=========");
////                return this.fallBack(Constant.SKIP_UNAUTHORIZED, exchange);
////            }
////        }
//
//        return chain.filter(exchange);
//    }
//
//    /****
//     * @Description 自定义返回信息提示
//     * @Param [url, exchange]
//     * @Author jpx
//     * @Version  1.0
//     * @Return reactor.core.publisher.Mono<java.lang.Void>
//     * @Exception
//     * @Date 2019/7/11
//     */
//    private Mono<Void> fallBack(String url,ServerWebExchange exchange){
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(HttpStatus.SEE_OTHER);
//        response.getHeaders().set("Location", url);
//        return exchange.getResponse().setComplete();
//    }
//
////    public boolean matchesDTO(String lookupPath, List<AuthorityDTO> authorityDTOList) {
////        if (ObjectUtils.isEmpty(authorityDTOList)) {
////            return false;
////        } else {
////            for (AuthorityDTO authorityDTO : authorityDTOList) {
////                if (matcher.match(authorityDTO.getValue(), lookupPath)) {
////                    return true;
////                }
////            }
////            return false;
////        }
////    }
//
//    public boolean matches(String lookupPath, List<String> includePatterns) {
//        if (ObjectUtils.isEmpty(includePatterns)) {
//            return false;
//        } else {
//            for (String pattern : includePatterns) {
//                if (matcher.match(pattern, lookupPath)) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return HIGHEST_PRECEDENCE;
//    }
//}
//
