package com.yangzq.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yangzq.study.eneity.Dept;
import com.yangzq.study.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.controller
 * @ClassName: DeptController
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/12 22:55
 * @Version: 1.0
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/depts",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/depts/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "methodFailFallback")
    public Dept get( @PathVariable("id") Long id){
        System.out.println(8001);
        Dept dept = deptService.getDept(id);
        if(dept == null){
            throw new RuntimeException();
        }
        return dept;
    }
    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public List<Dept> deptList(){
        return deptService.DeptList();
    }

    public Dept methodFailFallback( @PathVariable("id") Long id){
        Dept dept = new Dept();
        dept.setDname("default");
        dept.setDeptno(88888L);
        dept.setDb_source("null");
        return dept;
    }

    //eureka服务发现
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        System.out.println("*********" + list);
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance e :
            serviceInstances) {
            System.out.println(e.getServiceId() + "\t"
                +  e.getHost() + "\t"
                +  e.getPort() + "\t"
                +  e.getUri() + "\t"
                + e.isSecure());
        }
        return this.discoveryClient;
    }
}
