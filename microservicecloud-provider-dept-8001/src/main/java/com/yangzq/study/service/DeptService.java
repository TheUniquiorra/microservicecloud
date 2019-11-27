package com.yangzq.study.service;

import com.yangzq.study.eneity.Dept;

import java.util.List;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.service
 * @ClassName: DeptService
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/12 22:56
 * @Version: 1.0
 */
public interface DeptService {

    boolean add(Dept dept);

    Dept getDept(Long id);

    List<Dept> DeptList();
}
