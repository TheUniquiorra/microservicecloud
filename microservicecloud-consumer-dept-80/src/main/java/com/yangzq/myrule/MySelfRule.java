package com.yangzq.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public class MySelfRule {

    @Bean
    public IRule myRule() {
       // return new RandomRule();
        return new RandomRule_LW();
    }
}
