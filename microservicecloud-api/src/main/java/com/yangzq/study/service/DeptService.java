package com.yangzq.study.service;

import com.yangzq.study.eneity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.service
 * @ClassName: DeptService
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/18 22:32
 * @Version: 1.0
 */
@FeignClient(value = "http://MICROSERVICECLOUD-DEPT",fallbackFactory = com.yangzq.study.service.DeptServiceFallbackFactory.class)
public interface DeptService {

    @RequestMapping(value = "/depts", method = RequestMethod.POST)
    boolean add(Dept dept);

    @RequestMapping(value = "/depts/{id}", method = RequestMethod.GET)
    Dept getDept(@PathVariable("id") Long id);

    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    List<Dept> DeptList();
}
