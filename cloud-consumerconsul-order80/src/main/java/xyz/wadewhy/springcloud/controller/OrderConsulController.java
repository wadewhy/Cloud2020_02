package xyz.wadewhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.controller
 * @NAME: OrderConsulController
 * @Author: 钟子豪
 * @DATE: 2020/5/12
 * @MONTH_NAME_FULL: 五月
 * @DAY: 12
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: cloud2020_2
 **/
@RestController
@Slf4j
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
        return result;
    }
}
