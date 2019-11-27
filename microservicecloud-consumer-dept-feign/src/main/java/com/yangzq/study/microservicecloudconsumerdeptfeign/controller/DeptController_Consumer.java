package com.yangzq.study.microservicecloudconsumerdeptfeign.controller;

import com.yangzq.study.eneity.Dept;
import com.yangzq.study.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private DeptService service;


    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return this.service.getDept(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return this.service.DeptList();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        return this.service.add(dept);
    }



}
