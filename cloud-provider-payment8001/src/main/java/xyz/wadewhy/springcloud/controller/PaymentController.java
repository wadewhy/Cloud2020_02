package xyz.wadewhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import xyz.wadewhy.springcloud.entities.CommonResult;
import xyz.wadewhy.springcloud.entities.Payment;
import xyz.wadewhy.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.controller
 * @NAME: PaymentController
 * @Author: 钟子豪
 * @DATE: 2020/5/9
 * @MONTH_NAME_FULL: 五月
 * @DAY: 09
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: cloud2020
 **/
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;
    /**
     * 创建
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****create*****:" + result);
        if (result > 0) {//成功
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        } else {
            return new CommonResult(444, "插入失败", result);
        }
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****getPaymentById*****:" + payment.toString() + "哈哈");
        if (null != payment) {//成功
            return new CommonResult(200,"查询成功！！！,serverPort:"+serverPort,payment);
        } else {
            return new CommonResult(444, "查询失败，ID为：" + id, null);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element: services
             ) {
            log.info("discovery-----element------:"+element);
        }
        List<ServiceInstance> instances  = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
