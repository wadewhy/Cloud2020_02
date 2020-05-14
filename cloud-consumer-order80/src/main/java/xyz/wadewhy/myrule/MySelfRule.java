package xyz.wadewhy.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @PACKAGE_NAME: xyz.wadewhy.myrule
 * @NAME: MySelfRule
 * @Author: 钟子豪
 * @DATE: 2020/5/13
 * @MONTH_NAME_FULL: 五月
 * @DAY: 13
 * @DAY_NAME_FULL: 星期三
 * @PROJECT_NAME: cloud2020_2
 **/
//随机轮询
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
