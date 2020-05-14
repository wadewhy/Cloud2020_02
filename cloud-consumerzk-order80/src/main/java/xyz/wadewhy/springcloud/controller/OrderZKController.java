package xyz.wadewhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.controller
 * @NAME: OrderZKController
 * @Author: 钟子豪
 * @DATE: 2020/5/12
 * @MONTH_NAME_FULL: 五月
 * @DAY: 12
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: cloud2020_2
 **/
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOME_URL="http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;
    @GetMapping("/consumer/payment/zk")
    public String payment(){
        String result = restTemplate.getForObject(INVOME_URL+"/payment/zk",String.class);
        return result;
    }
}
