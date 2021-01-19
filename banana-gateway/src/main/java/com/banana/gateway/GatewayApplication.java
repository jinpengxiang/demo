package com.banana.gateway;

import com.banana.gateway.filter.UrlFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})//(scanBasePackages = Constant.COM_KITEDGE, exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients//(basePackages = Constant.COM_KITEDGE)
@EnableConfigurationProperties(Properties.class)
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RequestTimeFilter requestTimeFilter() {
        return new RequestTimeFilter();
    }

    @Bean
    public UrlFilter tokenFilter() {
        return new UrlFilter();
    }
}
