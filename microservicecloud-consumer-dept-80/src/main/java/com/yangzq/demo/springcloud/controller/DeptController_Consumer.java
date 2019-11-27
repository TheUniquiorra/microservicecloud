package com.yangzq.demo.springcloud.controller;

import com.yangzq.study.eneity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * <p>Description: </p>
 *
 * @author yangzq_sinosoft
 * @Date 2019/11/14 22:40
 * @Version 1.0.0
 * @param
 * @return 
 */
@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){
        System.out.println("test");
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/depts", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/depts/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/depts", List.class);
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }


}
