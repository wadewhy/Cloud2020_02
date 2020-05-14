package xyz.wadehwy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PACKAGE_NAME: xyz.wadehwy.springcloud
 * @NAME: PaymentMain8006
 * @Author: 钟子豪
 * @DATE: 2020/5/12
 * @MONTH_NAME_FULL: 五月
 * @DAY: 12
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: cloud2020_2
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
    }
}
