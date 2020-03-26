package com.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/***
 * JVM启动参数（日志输出）
 * -Dspring.profiles.active=local
 * */
@SpringBootApplication
@EnableFeignClients("com.kitedge")
@EnableDiscoveryClient
@MapperScan("com.test.mapper")
public class AppStarterTestAction {
    public static void main(String[] args) {
        SpringApplication.run(AppStarterTestAction.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Autowired
//    private Swagger2AutoConfig swagger2AutoConfig;
//    @Bean
//    public Docket createRestApi() {
//        Parameter tokenParam = (
//                new ParameterBuilder())
//                .name("token2222").description("token验证")
//                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        List<Parameter> pars = new ArrayList();
//        pars.add(tokenParam);
//        return (new Docket(DocumentationType.SWAGGER_2)).apiInfo(swagger2AutoConfig.apiInfo())
//                .select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any()).build().globalOperationParameters(pars);
//    }

//    @Bean
//    @ConfigurationProperties(prefix = "banana.datasource")
//    public DataSource dataSource() {
//        return new DruidDataSource();
//    }

//    @Bean
//    @ConditionalOnMissingBean(FilterRegistrationBean.class)
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        //TODO 过滤文件类型
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        //TODO 监控单个url调用的sql列表
//        filterRegistrationBean.addInitParameter("profileEnable", "true");
//        return filterRegistrationBean;
//    }
//
//    @Bean
////    @ConditionalOnMissingBean(ServletRegistrationBean.class)
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean reg = new ServletRegistrationBean();
//        reg.setServlet(new StatViewServlet());
//        reg.addUrlMappings("/druid/*");
//        //TODO 配置用户名
//        reg.addInitParameter("loginUsername", "admin");
//        //TODO 配置密码
//        reg.addInitParameter("loginPassword", "admin");
//        //TODO 在日志中打印执行慢的sql语句
//        reg.addInitParameter("logSlowSql", "true");
//        //TODO 另外还可配置黑白名单等信息，可参考druid官网介绍
//        return reg;
//    }
}
