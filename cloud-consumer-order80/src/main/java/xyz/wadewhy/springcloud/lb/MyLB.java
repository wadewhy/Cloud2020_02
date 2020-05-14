package xyz.wadewhy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @PACKAGE_NAME: xyz.wadewhy.springcloud.lb
 * @NAME: MyLB
 * @Author: 钟子豪
 * @DATE: 2020/5/13
 * @MONTH_NAME_FULL: 五月
 * @DAY: 13
 * @DAY_NAME_FULL: 星期三
 * @PROJECT_NAME: cloud2020_2
 **/
//扫描到ioc中
@Component
public class MyLB implements LoadBalancer {
    //自动增长的数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            //得到每次的数
            current = this.atomicInteger.get();
            /*
            2147483647表示整型最大的数
            compareAndSet表示CAS算法，可自行百度了解
             */
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.err.println("--------第几次访问---------"+next);
        return next;
    }
//负载均衡轮询算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标  ，每次服务重启动后rest接口计数从1开始。

    /**
     *
     * @param serviceInstances 集群里机器个数
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
