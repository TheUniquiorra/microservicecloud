package com.yangzq.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study
 * @ClassName: ProviderDeptApplication
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/11 22:36
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.yangzq.study.mapper")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class ProviderDeptApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderDeptApplication.class,args);
    }
}
