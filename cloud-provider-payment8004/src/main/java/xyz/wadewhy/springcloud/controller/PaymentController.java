package xyz.wadewhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.controller
 * @NAME: PaymentController
 * @Author: 钟子豪
 * @DATE: 2020/5/12
 * @MONTH_NAME_FULL: 五月
 * @DAY: 12
 * @DAY_NAME_FULL: 星期二
 * @PROJECT_NAME: cloud2020_2
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value="/payment/zk")
    public String paymentzk(){
        return "springcloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
