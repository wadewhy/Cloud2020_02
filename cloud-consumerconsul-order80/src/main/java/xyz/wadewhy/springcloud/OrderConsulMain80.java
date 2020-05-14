package xyz.wadewhy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud
 * @NAME: OrderConsulMain80
 * @Author: 钟子豪
 * @DATE: 2020/5/12
 * @MONTH_NAME_FULL: 五月
 * @DAY: 12
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: cloud2020_2
 **/
@SpringBootApplication
//该注解用于向使用consul或者zookeeper作为注册中心时注册服务
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class, args);
    }
}
