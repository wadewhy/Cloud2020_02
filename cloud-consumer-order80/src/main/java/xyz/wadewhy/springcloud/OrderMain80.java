package xyz.wadewhy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import xyz.wadewhy.myrule.MySelfRule;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud
 * @NAME: OrderMain80
 * @Author: 钟子豪
 * @DATE: 2020/5/9
 * @MONTH_NAME_FULL: 五月
 * @DAY: 09
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: cloud2020
 **/
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
