package xyz.wadewhy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.config
 * @NAME: ApplicationContextConfig
 * @Author: 钟子豪
 * @DATE: 2020/5/12
 * @MONTH_NAME_FULL: 五月
 * @DAY: 12
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: cloud2020_2
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    //负载均衡使用
    @LoadBalanced
    public RestTemplate getRestTemplate(){
            return new RestTemplate();
    }
}
