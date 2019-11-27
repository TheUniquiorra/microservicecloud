package com.yangzq.study.service;

import com.yangzq.study.eneity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: microservicecloud
 * @Package: com.yangzq.study.factory
 * @ClassName: DeptServiceFallbackFactory
 * @Author: yangzq_sinosoft
 * @Description:
 * @Date: 2019/11/24 21:57
 * @Version: 1.0
 */
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<DeptService> {
    @Override
    public DeptService create(Throwable throwable) {
        return new DeptService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept getDept(Long id) {
                Dept dept = new Dept();
                dept.setDname("default");
                dept.setDeptno(88888L);
                dept.setDb_source("null");
                return dept;
            }

            @Override
            public List<Dept> DeptList() {
                return null;
            }
        };
    }
}
