package xyz.wadewhy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xyz.wadewhy.springcloud.entities.CommonResult;
import xyz.wadewhy.springcloud.entities.Payment;
import xyz.wadewhy.springcloud.lb.LoadBalancer;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.controller
 * @NAME: OrderController
 * @Author: 钟子豪
 * @DATE: 2020/5/9
 * @MONTH_NAME_FULL: 五月
 * @DAY: 09
 * @DAY_NAME_FULL: 星期六
 * @PROJECT_NAME: cloud2020
 **/
@RestController
@Slf4j
public class OrderController {
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    //微服务之间的调用
    /*
    restTemplate.getForObject
    restTemplate.postForObject
     */
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create ( Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment , CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id , CommonResult.class);
    }

   /*
    restTemplate.getForEntity
    restTemplate.postForEntity
    */

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }
    }
    @GetMapping("/consumer/payment/postForEntity/create")
    public CommonResult<Payment> create2(Payment payment){
    return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment , CommonResult.class).getBody();
    }

    /**
     * 调用自己写轮询算法
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0)
        {
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        System.err.println(uri);
        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }
}
