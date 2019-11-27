package com.yangzq.study.microservicecloudconsumerdeptfeign.cfgbeans;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import com.yangzq.study.service.DeptServiceFallbackFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description: </p>
 *
 * @author yangzq_sinosoft
 * @Date 2019/11/14 22:36
 * @Version 1.0.0
 * @param
 * @return 
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public DeptServiceFallbackFactory getInstance(){
        return new DeptServiceFallbackFactory();
    }

    @Bean
    public IRule myRule() {
//        return new RandomRule();
        //需要重新制定负载均衡策略，如果不指定策略则一直会以RoundRobinRule规则进行重试
        //在一个配置时间段内当选择server不成功，则一直尝试使用subRule的方式选择一个可用的server
        return new RetryRule(new AvailabilityFilteringRule());
    }

}
