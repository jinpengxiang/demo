package com.banana.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
//@Component
public class LogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        RecorderServerHttpRequestDecorator requestDecorator = new RecorderServerHttpRequestDecorator(request);
        String path = request.getURI().getRawPath();
        String params = getParams(request);
        String headers = getHeaders(request);
        HttpMethod method = request.getMethod();
        if (HttpMethod.PUT.equals(method) || HttpMethod.POST.equals(method)) {
            log.info("request | {}  {} \n | headers: {} \n | body: {} "
                    , method, path, headers, requestDecorator.getBodyString());
        } else {
            log.info("request | {}  {} \n | headers: {} \n | params: {} "
                    , method, path, headers, params);
        }
        return chain.filter(exchange.mutate().request(requestDecorator).build());
    }

    @Override
    public int getOrder() {
        return -2;
    }

    private String getParams(ServerHttpRequest request) {
        Set<Map.Entry<String, List<String>>> set = request.getQueryParams().entrySet();
        return getLogString(set);
    }

    private String getHeaders(ServerHttpRequest request) {
        Set<Map.Entry<String, List<String>>> set = request.getHeaders().entrySet();
        return getLogString(set);
    }

    private String getLogString(Set<Map.Entry<String, List<String>>> set) {
        if (set.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : set) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }
        return sb.toString();
    }


    private class RecorderServerHttpRequestDecorator extends ServerHttpRequestDecorator {

        private final List<DataBuffer> dataBuffers = new ArrayList<>();
        private StringBuilder sb = new StringBuilder();

        public RecorderServerHttpRequestDecorator(ServerHttpRequest delegate) {
            super(delegate);
            super.getBody().map(dataBuffer -> {
                String s = StandardCharsets.UTF_8.decode(dataBuffer.asByteBuffer()).toString();
                sb.append(s);
                dataBuffers.add(dataBuffer);
                return dataBuffer;
            }).subscribe();
        }

        @Override
        public Flux<DataBuffer> getBody() {
            return Flux.fromIterable(dataBuffers)
                    .map(buf -> buf.factory().wrap(buf.asByteBuffer()));
        }

        public String getBodyString() {
            return sb.toString();
        }

    }
}